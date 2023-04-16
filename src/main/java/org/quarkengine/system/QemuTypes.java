package org.quarkengine.system;

public class QemuTypes {
    public static String getBoolean(boolean strs){
        return ( strs ? "on" : "off" );
    }
    public static enum RamSize{
        K,
        M,
        G
        /*,T,E*/
    }

    public static enum DiskSize{
        K,
        M,
        G,
        T,
        E
    }
    
    public static enum VgaType{
        std,cirrus,vmware,qxl,xenfb,tcx,cg3,virtio,none
    }

    public static enum NicType{
        tap,bridge,user,socket
    }

    public static enum DiskFormat {
        blkdebug,
        blklogwrites,
        blkverify,
        bochs,
        cloop,
        compress,
        copy_before_write("copy-before-write"),
        copy_on_read("copy-on-read"),
        dmg,
        file,
        ftp,
        ftps,
        host_device,
        http,
        https,
        luks,
        nbd,
        nfs,
        null_aio("null-aio"),
        null_co("null-co"),
        parallels,
        preallocate,
        qcow,
        qcow2,
        qed,
        quorum,
        raw,
        replication,
        snapshot_access("snapshot-access"),
        ssh,
        throttle,
        vdi,
        vhdx,
        vmdk,
        vpc,
        vvfat;

        private final String text;

        DiskFormat() {
            this.text = name();
        }

        DiskFormat(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public static enum CacheMode {
        none,
        writeback,
        writethrough,
        directsync,
        unsafe;

        @Override
        public String toString() {
            return name();
        }
    }



}
