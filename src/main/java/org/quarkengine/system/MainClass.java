package org.quarkengine.system;

import org.quarkengine.system.CommandBuilder.BootCommandBuilder;
import org.quarkengine.system.CommandBuilder.ImageCommandBuilder;
import org.quarkengine.system.CommandBuilder.PortForwarding;

import java.awt.*;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        PortForwarding pf = new PortForwarding();
        pf.add(new PortForwarding.NetworkAddress(PortForwarding.NetworkProtocol.tcp, "", 10022),
                new PortForwarding.NetworkAddress(PortForwarding.NetworkProtocol.tcp, "", 22));
        pf.add(new PortForwarding.NetworkAddress(PortForwarding.NetworkProtocol.tcp, "", 8080),
                new PortForwarding.NetworkAddress(PortForwarding.NetworkProtocol.tcp, "", 80));


        BootCommandBuilder bcb = new BootCommandBuilder("qemu-system-x86_64.exe");
        bcb.setMachine("q35");
        bcb.setCPU("qemu64")
                .setMemory(2048)
                .setCdrom("alpine-extended-3.17.3-x86_64.iso")
                .setUserNetworkWithForwarding("tap0",pf);

        System.out.println(bcb.build());

        ImageCommandBuilder icb = new ImageCommandBuilder("qemu-img.exe");
        icb.setCreate("mylinux.img", "qcow2", 100, QemuTypes.DiskSize.G);
        System.out.println(icb.build());

        // Or use that:
        /*ImageCommandBuilder icb = new ImageCommandBuilder("qemu-img.exe");
        icb.setCreate("mylinux.img", QemuTypes.DiskFormat.qcow2, 100, QemuTypes.DiskSize.G);
        System.out.println(icb.build());*/






    }
}