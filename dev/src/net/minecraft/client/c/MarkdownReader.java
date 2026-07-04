/*
 * Reading view for the Obsidian Book: parses the page's Markdown with
 * commonmark-java and renders a clean, syntax-free version for the in-game
 * book. The 8px font has no bold/italic, only colour codes (§0-§f), so
 * formatting is conveyed with colour + layout, and raw markers (#, **, -, `)
 * are hidden.
 */
package net.minecraft.client.c;

import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.Parser;

public final class MarkdownReader {
    private static final Parser PARSER = Parser.builder().build();

    public static String render(String markdown) {
        if (markdown == null || markdown.length() == 0) {
            return "";
        }
        try {
            Node document = PARSER.parse(markdown);
            Renderer renderer = new Renderer();
            document.accept(renderer);
            String out = renderer.sb.toString().replaceAll("\n{3,}", "\n\n");
            return out.trim();
        } catch (Throwable t) {
            return markdown; // fall back to raw text if anything goes wrong
        }
    }

    private static final class Renderer extends AbstractVisitor {
        final StringBuilder sb = new StringBuilder();
        private int orderedCounter = -1;

        @Override
        public void visit(Heading heading) {
            sb.append('\n');
            sb.append(heading.getLevel() <= 2 ? "§e" : "§6"); // yellow / gold
            visitChildren(heading);
            sb.append("§f\n");
        }

        @Override
        public void visit(Paragraph paragraph) {
            visitChildren(paragraph);
            sb.append("\n\n");
        }

        @Override
        public void visit(Text text) {
            sb.append(text.getLiteral());
        }

        @Override
        public void visit(StrongEmphasis strongEmphasis) {
            visitChildren(strongEmphasis); // markers hidden; font has no bold
        }

        @Override
        public void visit(Emphasis emphasis) {
            visitChildren(emphasis);
        }

        @Override
        public void visit(Code code) {
            sb.append("§7").append(code.getLiteral()).append("§f");
        }

        @Override
        public void visit(FencedCodeBlock block) {
            appendCodeBlock(block.getLiteral());
        }

        @Override
        public void visit(IndentedCodeBlock block) {
            appendCodeBlock(block.getLiteral());
        }

        private void appendCodeBlock(String literal) {
            for (String line : literal.split("\n")) {
                sb.append("§7").append(line).append("§f\n");
            }
            sb.append('\n');
        }

        @Override
        public void visit(BulletList bulletList) {
            int saved = orderedCounter;
            orderedCounter = -1;
            visitChildren(bulletList);
            orderedCounter = saved;
            sb.append('\n');
        }

        @Override
        public void visit(OrderedList orderedList) {
            int saved = orderedCounter;
            orderedCounter = orderedList.getStartNumber();
            visitChildren(orderedList);
            orderedCounter = saved;
            sb.append('\n');
        }

        @Override
        public void visit(ListItem listItem) {
            if (orderedCounter >= 0) {
                sb.append(orderedCounter++).append(". ");
            } else {
                sb.append("§6-§f ");
            }
            visitChildren(listItem);
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '\n') {
                sb.append('\n');
            }
        }

        @Override
        public void visit(BlockQuote blockQuote) {
            sb.append("§8>§7 "); // grey bar + grey text
            visitChildren(blockQuote);
            sb.append("§f\n");
        }

        @Override
        public void visit(Link link) {
            sb.append("§9"); // blue
            visitChildren(link);
            sb.append("§f");
        }

        @Override
        public void visit(ThematicBreak thematicBreak) {
            sb.append("§8----------------§f\n");
        }

        @Override
        public void visit(SoftLineBreak softLineBreak) {
            sb.append('\n');
        }

        @Override
        public void visit(HardLineBreak hardLineBreak) {
            sb.append('\n');
        }

        @Override
        public void visit(Document document) {
            visitChildren(document);
        }
    }
}
