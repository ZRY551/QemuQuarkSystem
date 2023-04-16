# About Project

这个项目是一个用Java生成Qemu启动参数的项目，支持Windows和Linux等平台。

This project is a project that generates Qemu startup parameters in Java, supporting platforms such as Windows and Linux.

# How to use

编译并将jar包添加到项目中，然后使用以下代码即可。
或者直接将源码和依赖添加到你的项目中。

Compile and add the jar package to the project, and then use the following code.
Or add the source code and dependencies directly to your project.


```java
import org.quarkengine.system.CommandBuilder.BootCommandBuilder;
import org.quarkengine.system.CommandBuilder.PortForwarding;

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
    }
}
```

这会输出一个字符串，用这个字符串就能够启动Qemu虚拟机了，并添加用户网络模式的端口转发。
同时还支持Qemu-Img的命令生成。

This will output a string that can be used to start the Qemu virtual machine and add user network mode port forwarding.
It also supports the generation of Qemu-Img commands.

Output输出结果:
```
Hello world!
qemu-system-x86_64.exe -machine q35 -cpu qemu64 -m size=2048 -cdrom "alpine-extended-3.17.3-x86_64.iso" -netdev user,id=tap0,hostfwd=tcp::10022-:22,hostfwd=tcp::8080-:80
```


```java
import org.quarkengine.system.CommandBuilder.ImageCommandBuilder;

public class MainClass {
    public static void main(String[] args) {
        ImageCommandBuilder icb = new ImageCommandBuilder("qemu-img.exe");
        icb.setCreate("mylinux.img", "qcow2", 100, QemuTypes.DiskSize.G);
        // Or use that:
        //icb.setCreate("mylinux.img", QemuTypes.DiskFormat.qcow2, 100, QemuTypes.DiskSize.G);
        System.out.println(icb.build());

        
    }
}
```

这会输出一个字符串命令行，用这个字符串就能够创建一个100G的qcow2格式的虚拟磁盘。

This will output a string command line that can be used to create a 100G qcow2 format virtual disk.

Output输出结果:
```
qemu-img.exe create -f qcow2 mylinux.img 100G
```

不仅支持创建，还支持其他操作，详细请看源码。

Not only does it support creation, but it also supports other operations. For details, please see the source code.

# More features

如果你想要更多的功能，可以自己添加，或者提出issue。
我希望这个项目能够帮助到你。

If you want more features, you can add them yourself or raise an issue.
I hope this project can help you.

# Why I do this

我正在试图开发一个用Java管理Qemu的项目，但是Qemu的启动参数太多了，我不想手动拼接和处理字符串，所以我写了这个项目。

I am trying to develop a project that manages Qemu with Java, but there are too many Qemu startup parameters, and I don't want to manually splice and process strings, so I wrote this project.

# Thanks

ChatGPT and Github Copilot.


# License

使用MIT作为开源协议。

Use MIT as the open source protocol.






































