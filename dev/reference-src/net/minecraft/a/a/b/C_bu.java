/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.C_k;
import net.minecraft.a.a.b.C_bc;
import net.minecraft.a.a.b.C_x;

class C_bu {
    private C_g worldObj;
    private int trackX;
    private int trackY;
    private int trackZ;
    private int trackMetadata;
    private List<C_k> connectedTracks;
    final C_bc minecartTrack;

    public C_bu(C_bc c_bc, C_g c_g, int n, int n2, int n3) {
        this.minecartTrack = c_bc;
        this.connectedTracks = new ArrayList<C_k>();
        this.worldObj = c_g;
        this.trackX = n;
        this.trackY = n2;
        this.trackZ = n3;
        this.trackMetadata = c_g.e(n, n2, n3);
        this.calculateConnectedTracks(this.trackMetadata);
    }

    private void calculateConnectedTracks(int n) {
        this.connectedTracks.clear();
        if (n == 0) {
            this.connectedTracks.add(new C_k(this.trackX, this.trackY, this.trackZ - 1));
            this.connectedTracks.add(new C_k(this.trackX, this.trackY, this.trackZ + 1));
        } else if (n == 1) {
            this.connectedTracks.add(new C_k(this.trackX - 1, this.trackY, this.trackZ));
            this.connectedTracks.add(new C_k(this.trackX + 1, this.trackY, this.trackZ));
        } else if (n == 2) {
            this.connectedTracks.add(new C_k(this.trackX - 1, this.trackY, this.trackZ));
            this.connectedTracks.add(new C_k(this.trackX + 1, this.trackY + 1, this.trackZ));
        } else if (n == 3) {
            this.connectedTracks.add(new C_k(this.trackX - 1, this.trackY + 1, this.trackZ));
            this.connectedTracks.add(new C_k(this.trackX + 1, this.trackY, this.trackZ));
        } else if (n == 4) {
            this.connectedTracks.add(new C_k(this.trackX, this.trackY + 1, this.trackZ - 1));
            this.connectedTracks.add(new C_k(this.trackX, this.trackY, this.trackZ + 1));
        } else if (n == 5) {
            this.connectedTracks.add(new C_k(this.trackX, this.trackY, this.trackZ - 1));
            this.connectedTracks.add(new C_k(this.trackX, this.trackY + 1, this.trackZ + 1));
        } else if (n == 6) {
            this.connectedTracks.add(new C_k(this.trackX + 1, this.trackY, this.trackZ));
            this.connectedTracks.add(new C_k(this.trackX, this.trackY, this.trackZ + 1));
        } else if (n == 7) {
            this.connectedTracks.add(new C_k(this.trackX - 1, this.trackY, this.trackZ));
            this.connectedTracks.add(new C_k(this.trackX, this.trackY, this.trackZ + 1));
        } else if (n == 8) {
            this.connectedTracks.add(new C_k(this.trackX - 1, this.trackY, this.trackZ));
            this.connectedTracks.add(new C_k(this.trackX, this.trackY, this.trackZ - 1));
        } else if (n == 9) {
            this.connectedTracks.add(new C_k(this.trackX + 1, this.trackY, this.trackZ));
            this.connectedTracks.add(new C_k(this.trackX, this.trackY, this.trackZ - 1));
        }
    }

    private void refreshConnectedTracks() {
        for (int i = 0; i < this.connectedTracks.size(); ++i) {
            C_bu c_bu = this.getMinecartTrackLogic(this.connectedTracks.get(i));
            if (c_bu != null && c_bu.isConnectedTo(this)) {
                this.connectedTracks.set(i, new C_k(c_bu.trackX, c_bu.trackY, c_bu.trackZ));
                continue;
            }
            this.connectedTracks.remove(i--);
        }
    }

    private boolean isMinecartTrack(int n, int n2, int n3) {
        C_x c_x = C_x.c[this.worldObj.a(n, n2, n3)];
        C_x c_x2 = C_x.c[this.worldObj.a(n, n2 + 1, n3)];
        C_x c_x3 = C_x.c[this.worldObj.a(n, n2 - 1, n3)];
        if (c_x instanceof C_bc) {
            return true;
        }
        if (c_x2 instanceof C_bc) {
            return true;
        }
        return c_x3 instanceof C_bc;
    }

    private C_bu getMinecartTrackLogic(C_k c_k) {
        C_x c_x = C_x.c[this.worldObj.a(c_k.x, c_k.y, c_k.z)];
        C_x c_x2 = C_x.c[this.worldObj.a(c_k.x, c_k.y + 1, c_k.z)];
        C_x c_x3 = C_x.c[this.worldObj.a(c_k.x, c_k.y - 1, c_k.z)];
        if (c_x instanceof C_bc) {
            return new C_bu(this.minecartTrack, this.worldObj, c_k.x, c_k.y, c_k.z);
        }
        if (c_x2 instanceof C_bc) {
            return new C_bu(this.minecartTrack, this.worldObj, c_k.x, c_k.y + 1, c_k.z);
        }
        return c_x3 instanceof C_bc ? new C_bu(this.minecartTrack, this.worldObj, c_k.x, c_k.y - 1, c_k.z) : null;
    }

    private boolean isConnectedTo(C_bu c_bu) {
        for (int i = 0; i < this.connectedTracks.size(); ++i) {
            C_k c_k = this.connectedTracks.get(i);
            if (c_k.x != c_bu.trackX || c_k.z != c_bu.trackZ) continue;
            return true;
        }
        return false;
    }

    private boolean isInTrack(int n, int n2, int n3) {
        for (int i = 0; i < this.connectedTracks.size(); ++i) {
            C_k c_k = this.connectedTracks.get(i);
            if (c_k.x != n || c_k.z != n3) continue;
            return true;
        }
        return false;
    }

    private int getAdjacentTracks() {
        int n = 0;
        if (this.isMinecartTrack(this.trackX, this.trackY, this.trackZ - 1)) {
            ++n;
        }
        if (this.isMinecartTrack(this.trackX, this.trackY, this.trackZ + 1)) {
            ++n;
        }
        if (this.isMinecartTrack(this.trackX - 1, this.trackY, this.trackZ)) {
            ++n;
        }
        if (this.isMinecartTrack(this.trackX + 1, this.trackY, this.trackZ)) {
            ++n;
        }
        return n;
    }

    private boolean canConnectTo(C_bu c_bu) {
        if (this.isConnectedTo(c_bu)) {
            return true;
        }
        if (this.connectedTracks.size() == 2) {
            return false;
        }
        if (this.connectedTracks.size() == 0) {
            return true;
        }
        C_k c_k = this.connectedTracks.get(0);
        return c_bu.trackY == this.trackY && c_k.y == this.trackY ? true : true;
    }

    private void connectToNeighbor(C_bu c_bu) {
        this.connectedTracks.add(new C_k(c_bu.trackX, c_bu.trackY, c_bu.trackZ));
        boolean bl = this.isInTrack(this.trackX, this.trackY, this.trackZ - 1);
        boolean bl2 = this.isInTrack(this.trackX, this.trackY, this.trackZ + 1);
        boolean bl3 = this.isInTrack(this.trackX - 1, this.trackY, this.trackZ);
        boolean bl4 = this.isInTrack(this.trackX + 1, this.trackY, this.trackZ);
        C_x c_x = C_x.c[this.worldObj.a(this.trackX, this.trackY + 1, this.trackZ - 1)];
        C_x c_x2 = C_x.c[this.worldObj.a(this.trackX, this.trackY + 1, this.trackZ + 1)];
        C_x c_x3 = C_x.c[this.worldObj.a(this.trackX + 1, this.trackY + 1, this.trackZ)];
        C_x c_x4 = C_x.c[this.worldObj.a(this.trackX - 1, this.trackY + 1, this.trackZ)];
        int n = -1;
        if (bl || bl2) {
            n = 0;
        }
        if (bl3 || bl4) {
            n = 1;
        }
        if (bl2 && bl4 && !bl && !bl3) {
            n = 6;
        }
        if (bl2 && bl3 && !bl && !bl4) {
            n = 7;
        }
        if (bl && bl3 && !bl2 && !bl4) {
            n = 8;
        }
        if (bl && bl4 && !bl2 && !bl3) {
            n = 9;
        }
        if (n == 0) {
            if (c_x instanceof C_bc) {
                n = 4;
            }
            if (c_x2 instanceof C_bc) {
                n = 5;
            }
        }
        if (n == 1) {
            if (c_x3 instanceof C_bc) {
                n = 2;
            }
            if (c_x4 instanceof C_bc) {
                n = 3;
            }
        }
        if (n < 0) {
            n = 0;
        }
        this.worldObj.setBlockMetadataWithNotify(this.trackX, this.trackY, this.trackZ, n);
    }

    private boolean canConnectFrom(int n, int n2, int n3) {
        C_bu c_bu = this.getMinecartTrackLogic(new C_k(n, n2, n3));
        if (c_bu == null) {
            return false;
        }
        c_bu.refreshConnectedTracks();
        return c_bu.canConnectTo(this);
    }

    public void place(boolean bl, boolean bl2) {
        boolean bl3 = this.canConnectFrom(this.trackX, this.trackY, this.trackZ - 1);
        boolean bl4 = this.canConnectFrom(this.trackX, this.trackY, this.trackZ + 1);
        boolean bl5 = this.canConnectFrom(this.trackX - 1, this.trackY, this.trackZ);
        boolean bl6 = this.canConnectFrom(this.trackX + 1, this.trackY, this.trackZ);
        C_x c_x = C_x.c[this.worldObj.a(this.trackX, this.trackY + 1, this.trackZ - 1)];
        C_x c_x2 = C_x.c[this.worldObj.a(this.trackX, this.trackY + 1, this.trackZ + 1)];
        C_x c_x3 = C_x.c[this.worldObj.a(this.trackX + 1, this.trackY + 1, this.trackZ)];
        C_x c_x4 = C_x.c[this.worldObj.a(this.trackX - 1, this.trackY + 1, this.trackZ)];
        int n = -1;
        if ((bl3 || bl4) && !bl5 && !bl6) {
            n = 0;
        }
        if ((bl5 || bl6) && !bl3 && !bl4) {
            n = 1;
        }
        if (bl4 && bl6 && !bl3 && !bl5) {
            n = 6;
        }
        if (bl4 && bl5 && !bl3 && !bl6) {
            n = 7;
        }
        if (bl3 && bl5 && !bl4 && !bl6) {
            n = 8;
        }
        if (bl3 && bl6 && !bl4 && !bl5) {
            n = 9;
        }
        if (n == -1) {
            if (bl3 || bl4) {
                n = 0;
            }
            if (bl5 || bl6) {
                n = 1;
            }
            if (bl) {
                if (bl4 && bl6) {
                    n = 6;
                }
                if (bl5 && bl4) {
                    n = 7;
                }
                if (bl6 && bl3) {
                    n = 9;
                }
                if (bl3 && bl5) {
                    n = 8;
                }
            } else {
                if (bl3 && bl5) {
                    n = 8;
                }
                if (bl6 && bl3) {
                    n = 9;
                }
                if (bl5 && bl4) {
                    n = 7;
                }
                if (bl4 && bl6) {
                    n = 6;
                }
            }
        }
        if (n == 0) {
            if (c_x instanceof C_bc) {
                n = 4;
            }
            if (c_x2 instanceof C_bc) {
                n = 5;
            }
        }
        if (n == 1) {
            if (c_x3 instanceof C_bc) {
                n = 2;
            }
            if (c_x4 instanceof C_bc) {
                n = 3;
            }
        }
        if (n < 0) {
            n = 0;
        }
        this.trackMetadata = n;
        this.calculateConnectedTracks(n);
        if (bl2 || this.worldObj.e(this.trackX, this.trackY, this.trackZ) != n) {
            this.worldObj.setBlockMetadataWithNotify(this.trackX, this.trackY, this.trackZ, n);
            for (int i = 0; i < this.connectedTracks.size(); ++i) {
                C_bu c_bu = this.getMinecartTrackLogic(this.connectedTracks.get(i));
                if (c_bu == null) continue;
                c_bu.refreshConnectedTracks();
                if (!c_bu.canConnectTo(this)) continue;
                c_bu.connectToNeighbor(this);
            }
        }
    }

    static int getNAdjacentTracks(C_bu c_bu) {
        return c_bu.getAdjacentTracks();
    }
}

