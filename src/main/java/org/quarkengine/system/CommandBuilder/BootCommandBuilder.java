package org.quarkengine.system.CommandBuilder;

import org.quarkengine.system.QemuTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BootCommandBuilder {
    public String mainProcess = "";

    public List<String> bootCommand = new ArrayList<String>();

    public BootCommandBuilder(String mainProcess) {
        this.mainProcess = mainProcess;
    }

    public BootCommandBuilder add(String command) {
        this.bootCommand.add(command);
        return this;
    }

    public BootCommandBuilder set(String command){
        this.bootCommand.add(command);
        return this;
    }

    public void add(String... command){
        for (String s : command) {
            this.bootCommand.add(s);
        }
    }

    public void add(List<String> command){
        for (String s : command) {
            this.bootCommand.add(s);
        }
    }

    public String build() {
        String command = this.mainProcess;
        for (String s : this.bootCommand) {
            command += " " + s;
        }
        return command;
    }

    public List<String> buildList() {
        List<String> command = new ArrayList<String>();
        command.add(this.mainProcess);
        command.addAll(this.bootCommand);
        return command;
    }

    public static BootCommandBuilder create(String mainProcess) {
        return new BootCommandBuilder(mainProcess);
    }

    ////////////////////////////////////////////////////////////////////////

    /**
     * Qemu Command Line Builder
     * */

    public BootCommandBuilder setMachine(String machine){
        this.bootCommand.add("-machine " + machine);
        return this;
    }

    public BootCommandBuilder setMachine(String machine,String otherargs){
        this.bootCommand.add("-machine " + machine + "," + otherargs);
        return this;
    }

    public BootCommandBuilder setCPU(String cpu){
        this.bootCommand.add("-cpu " + cpu);
        return this;
    }

    public BootCommandBuilder setAccel(String accelerator){
        this.bootCommand.add("-accel " + accelerator);
        return this;
    }

    public BootCommandBuilder setAccel(String accelerator,String otherargs){
        this.bootCommand.add("-accel " + accelerator + "," + otherargs);
        return this;
    }

    /**
     * -smp [[cpus=]n][,maxcpus=maxcpus][,sockets=sockets][,dies=dies][,clusters=clusters][,cores=cores][,threads=threads]
     *                 set the number of initial CPUs to 'n' [default=1]
     *                 maxcpus= maximum number of total CPUs, including
     *                 offline CPUs for hotplug, etc
     *                 sockets= number of sockets on the machine board
     *                 dies= number of dies in one socket
     *                 clusters= number of clusters in one die
     *                 cores= number of cores in one cluster
     *                 threads= number of threads in one core
     * */

    public BootCommandBuilder setSmp(int smp){
        this.bootCommand.add("-smp " + smp);
        return this;
    }

    public BootCommandBuilder setSmp(int smp,String otherargs){
        this.bootCommand.add("-smp " + smp + "," + otherargs);
        return this;
    }

    public BootCommandBuilder setSmp(int smp,int maxcpus){
        this.bootCommand.add("-smp " + smp + ",maxcpus=" + maxcpus);
        return this;
    }

    public BootCommandBuilder setSmp(int smp,int maxcpus,String otherargs){
        this.bootCommand.add("-smp " + smp + ",maxcpus=" + maxcpus + "," + otherargs);
        return this;
    }

    public BootCommandBuilder setSmp(int smp,int maxcpus,int sockets){
        this.bootCommand.add("-smp " + smp + ",maxcpus=" + maxcpus + ",sockets=" + sockets);
        return this;
    }

    public BootCommandBuilder setSmp(int smp,int maxcpus,int sockets,String otherargs){
        this.bootCommand.add("-smp " + smp + ",maxcpus=" + maxcpus + ",sockets=" + sockets + "," + otherargs);
        return this;
    }

    public BootCommandBuilder setSmp(int smp,int maxcpus,int sockets,int dies){
        this.bootCommand.add("-smp " + smp + ",maxcpus=" + maxcpus + ",sockets=" + sockets + ",dies=" + dies);
        return this;
    }

    public BootCommandBuilder setSmp(int smp,int maxcpus,int sockets,int dies,String otherargs){
        this.bootCommand.add("-smp " + smp + ",maxcpus=" + maxcpus + ",sockets=" + sockets + ",dies=" + dies + "," + otherargs);
        return this;
    }

    public BootCommandBuilder setSmp(int smp,int maxcpus,int sockets,int dies,int clusters){
        this.bootCommand.add("-smp " + smp + ",maxcpus=" + maxcpus + ",sockets=" + sockets + ",dies=" + dies + ",clusters=" + clusters);
        return this;
    }
    public BootCommandBuilder setSmp(int smp,int maxcpus,int sockets,int dies,int clusters,String otherargs){
        this.bootCommand.add("-smp " + smp + ",maxcpus=" + maxcpus + ",sockets=" + sockets + ",dies=" + dies + ",clusters=" + clusters + "," + otherargs);
        return this;
    }

    public BootCommandBuilder setSmp(int smp,int maxcpus,int sockets,int dies,int clusters,int cores){
        this.bootCommand.add("-smp " + smp + ",maxcpus=" + maxcpus + ",sockets=" + sockets + ",dies=" + dies + ",clusters=" + clusters + ",cores=" + cores);
        return this;
    }
    public BootCommandBuilder setSmp(int smp,int maxcpus,int sockets,int dies,int clusters,int cores,String otherargs){
        this.bootCommand.add("-smp " + smp + ",maxcpus=" + maxcpus + ",sockets=" + sockets + ",dies=" + dies + ",clusters=" + clusters + ",cores=" + cores + "," + otherargs);
        return this;
    }

    public BootCommandBuilder setSmp(int smp,int maxcpus,int sockets,int dies,int clusters,int cores,int threads){
        this.bootCommand.add("-smp " + smp + ",maxcpus=" + maxcpus + ",sockets=" + sockets + ",dies=" + dies + ",clusters=" + clusters + ",cores=" + cores + ",threads=" + threads);
        return this;
    }

    public BootCommandBuilder setSmp(int smp,int maxcpus,int sockets,int dies,int clusters,int cores,int threads,String otherargs){
        this.bootCommand.add("-smp " + smp + ",maxcpus=" + maxcpus + ",sockets=" + sockets + ",dies=" + dies + ",clusters=" + clusters + ",cores=" + cores + ",threads=" + threads + "," + otherargs);
        return this;
    }

    /**
     * -numa node[,mem=size][,cpus=firstcpu[-lastcpu]][,nodeid=node][,initiator=node]
     * -numa node[,memdev=id][,cpus=firstcpu[-lastcpu]][,nodeid=node][,initiator=node]
     * -numa dist,src=source,dst=destination,val=distance
     * -numa cpu,node-id=node[,socket-id=x][,core-id=y][,thread-id=z]
     * -numa hmat-lb,initiator=node,target=node,hierarchy=memory|first-level|second-level|third-level,data-type=access-latency|read-latency|write-latency[,latency=lat][,bandwidth=bw]
     * -numa hmat-cache,node-id=node,size=size,level=level[,associativity=none|direct|complex][,policy=none|write-back|write-through][,line=size]
     * -add-fd fd=fd,set=set[,opaque=opaque]
     *                 Add 'fd' to fd 'set'
     * -set group.id.arg=value
     *                 set <arg> parameter for item <id> of type <group>
     *                 i.e. -set drive.$id.file=/path/to/image
     * -global driver.property=value
     * -global driver=driver,property=property,value=value
     *                 set a global default for a driver property
     * -boot [order=drives][,once=drives][,menu=on|off]
     *       [,splash=sp_name][,splash-time=sp_time][,reboot-timeout=rb_time][,strict=on|off]
     *                 'drives': floppy (a), hard disk (c), CD-ROM (d), network (n)
     *                 'sp_name': the file's name that would be passed to bios as logo picture, if menu=on
     *                 'sp_time': the period that splash picture last if menu=on, unit is ms
     *                 'rb_timeout': the timeout before guest reboot when boot failed, unit is ms
     * -m [size=]megs[,slots=n,maxmem=size]
     *                 configure guest RAM
     *                 size: initial amount of guest memory
     *                 slots: number of hotplug slots (default: none)
     *                 maxmem: maximum amount of guest memory (default: none)*/

    public BootCommandBuilder setNumaNode(int node,int mem,String cpus,int nodeid,int initiator){
        this.bootCommand.add("-numa node,mem=" + mem + ",cpus=" + cpus + ",nodeid=" + nodeid + ",initiator=" + initiator);
        return this;
    }
    public BootCommandBuilder setNumaNode(int node,int mem,String cpus,int nodeid,int initiator,String otherargs){
        this.bootCommand.add("-numa node,mem=" + mem + ",cpus=" + cpus + ",nodeid=" + nodeid + ",initiator=" + initiator + "," + otherargs);
        return this;
    }
    public BootCommandBuilder setNumaNode(){
        this.bootCommand.add("-numa node");
        return this;
    }

    public BootCommandBuilder setNuma(String args){
        this.bootCommand.add("-numa " + args);
        return this;
    }

    public BootCommandBuilder setAddFd(int fd,int set,String opaque){
        this.bootCommand.add("-add-fd fd=" + fd + ",set=" + set + ",opaque=" + opaque);
        return this;
    }
    public BootCommandBuilder setAddFd(int fd,int set){
        this.bootCommand.add("-add-fd fd=" + fd + ",set=" + set);
        return this;
    }

    public BootCommandBuilder setSet(String args){
        this.bootCommand.add("-set " + args);
        return this;
    }
    public BootCommandBuilder setSet(String arg1,String arg2){
        this.bootCommand.add("-set " + arg1 + "=" + arg2);
        return this;
    }
    public BootCommandBuilder setGlobal(String args){
        this.bootCommand.add("-global " + args);
        return this;
    }
    public BootCommandBuilder setGlobal(HashMap<String,String> map){
        String args = "";
        for (Map.Entry<String,String> entry : map.entrySet()) {
            args += entry.getKey() + "=" + entry.getValue() + ",";
        }
        args = args.substring(0,args.length()-1);
        this.bootCommand.add("-global " + args);
        return this;
    }

    public BootCommandBuilder setBootArgs(String args){
        this.bootCommand.add("-boot " + args);
        return this;
    }
    public BootCommandBuilder setBoot(String order,String once,String menu,String splash,String splashTime,String rebootTimeout,String strict){
        this.bootCommand.add("-boot order=" + order + ",once=" + once + ",menu=" + menu + ",splash=" + splash + ",splash-time=" + splashTime + ",reboot-timeout=" + rebootTimeout + ",strict=" + strict);
        return this;
    }
    public BootCommandBuilder setBoot(String order,String once,String menu,String splash,String splashTime,String rebootTimeout){
        this.bootCommand.add("-boot order=" + order + ",once=" + once + ",menu=" + menu + ",splash=" + splash + ",splash-time=" + splashTime + ",reboot-timeout=" + rebootTimeout);
        return this;
    }
    public BootCommandBuilder setBoot(String order,String once,String menu,String splash,String splashTime){
        this.bootCommand.add("-boot order=" + order + ",once=" + once + ",menu=" + menu + ",splash=" + splash + ",splash-time=" + splashTime);
        return this;
    }
    public BootCommandBuilder setBoot(String order,String once,String menu,String splash){
        this.bootCommand.add("-boot order=" + order + ",once=" + once + ",menu=" + menu + ",splash=" + splash);
        return this;
    }
    public BootCommandBuilder setBoot(String order,String once,String menu){
        this.bootCommand.add("-boot order=" + order + ",once=" + once + ",menu=" + menu);
        return this;
    }
    public BootCommandBuilder setBoot(String order,String once){
        this.bootCommand.add("-boot order=" + order + ",once=" + once);
        return this;
    }
    public BootCommandBuilder setBoot(String order){
        this.bootCommand.add("-boot order=" + order);
        return this;
    }

    public BootCommandBuilder setMemory(int size,int slots,int maxmem){
        this.bootCommand.add("-m size=" + size + ",slots=" + slots + ",maxmem=" + maxmem);
        return this;
    }

    public BootCommandBuilder setMemory(int size, int slots, int maxmem, QemuTypes.RamSize ramSize){
        this.bootCommand.add("-m size=" + size + ramSize.toString() + ",slots=" + slots + ",maxmem=" + maxmem + ramSize.toString());
        return this;
    }
    public BootCommandBuilder setMemory(int size,int slots){
        this.bootCommand.add("-m size=" + size + ",slots=" + slots);
        return this;
    }
    public BootCommandBuilder setMemory(int size){
        this.bootCommand.add("-m size=" + size);
        return this;
    }

    public BootCommandBuilder setMemory(int size,int slots,QemuTypes.RamSize ramSize){
        this.bootCommand.add("-m size=" + size + ramSize.toString() + ",slots=" + slots);
        return this;
    }
    public BootCommandBuilder setMemory(int size,QemuTypes.RamSize ramSize){
        this.bootCommand.add("-m size=" + size + ramSize.toString());
        return this;
    }

    public BootCommandBuilder setMemory(String args){
        this.bootCommand.add("-m " + args);
        return this;
    }

    public BootCommandBuilder setMemPath(String path){
        this.bootCommand.add("-mem-path \"" + path + "\"");
        return this;
    }

    public BootCommandBuilder setMemPreAlloc(){
        this.bootCommand.add("-mem-prealloc");
        return this;
    }

    public BootCommandBuilder setKeyboardLayout(String layout){
        this.bootCommand.add("-k " + layout);
        return this;
    }

    /**
     * -audio [driver=]driver,model=value[,prop[=value][,...]]
     *                 specifies the audio backend and device to use;
     *                 apart from 'model', options are the same as for -audiodev.
     *                 use '-audio model=help' to show possible devices.
     * -audiodev [driver=]driver,id=id[,prop[=value][,...]]
     *                 specifies the audio backend to use
     *                 Use ``-audiodev help`` to list the available drivers
     *                 id= identifier of the backend
     *                 timer-period= timer period in microseconds
     *                 in|out.mixing-engine= use mixing engine to mix streams inside QEMU
     *                 in|out.fixed-settings= use fixed settings for host audio
     *                 in|out.frequency= frequency to use with fixed settings
     *                 in|out.channels= number of channels to use with fixed settings
     *                 in|out.format= sample format to use with fixed settings
     *                 valid values: s8, s16, s32, u8, u16, u32, f32
     *                 in|out.voices= number of voices to use
     *                 in|out.buffer-length= length of buffer in microseconds
     * -audiodev none,id=id,[,prop[=value][,...]]
     *                 dummy driver that discards all output
     * -audiodev dsound,id=id[,prop[=value][,...]]
     *                 latency= add extra latency to playback in microseconds
     * -audiodev sdl,id=id[,prop[=value][,...]]
     *                 in|out.buffer-count= number of buffers
     * -audiodev spice,id=id[,prop[=value][,...]]
     * -audiodev wav,id=id[,prop[=value][,...]]
     *                 path= path of wav file to record*/

    public BootCommandBuilder setAudio(String driver,String model){
        this.bootCommand.add("-audio driver=" + driver + ",model=" + model);
        return this;
    }
    public BootCommandBuilder setAudio(String driver,String model,String otherargs){
        this.bootCommand.add("-audio driver=" + driver + ",model=" + model + "," + otherargs);
        return this;
    }
    public BootCommandBuilder setAudio(String args){
        this.bootCommand.add("-audio " + args);
        return this;
    }

    public BootCommandBuilder setAudioDev(String driver,String id){
        this.bootCommand.add("-audiodev driver=" + driver + ",id=" + id);
        return this;
    }
    public BootCommandBuilder setAudioDev(String driver,String id,String otherargs){
        this.bootCommand.add("-audiodev driver=" + driver + ",id=" + id + "," + otherargs);
        return this;
    }
    public BootCommandBuilder setAudioDev(String args){
        this.bootCommand.add("-audiodev " + args);
        return this;
    }

    /**-device driver[,prop[=value][,...]]
     add device (based on driver)
     prop=value,... sets driver properties
     use '-device help' to print all possible drivers
     use '-device driver,help' to print all possible properties
     -name string1[,process=string2][,debug-threads=on|off]
     set the name of the guest
     string1 sets the window title and string2 the process name
     When debug-threads is enabled, individual threads are given a separate name
     NOTE: The thread names are for debugging and not a stable API.
     -uuid %08x-%04x-%04x-%04x-%012x
     specify machine UUID*/
    public BootCommandBuilder setDevice(String args){
        this.bootCommand.add("-device " + args);
        return this;
    }
    public BootCommandBuilder setDevice(String driver,String otherargs){
        this.bootCommand.add("-device " + driver + "," + otherargs);
        return this;
    }
    public BootCommandBuilder setDevice(String driver,String id,String otherargs){
        this.bootCommand.add("-device " + driver + ",id=" + id + "," + otherargs);
        return this;
    }
    public BootCommandBuilder setName(String name){
        this.bootCommand.add("-name " + name);
        return this;
    }
    public BootCommandBuilder setName(String name,String process){
        this.bootCommand.add("-name " + name + ",process=" + process);
        return this;
    }
    public BootCommandBuilder setName(String name,String process,boolean debugThreads){
        this.bootCommand.add("-name " + name + ",process=" + process + ",debug-threads=" + (debugThreads ? "on" : "off"));
        return this;
    }
    public BootCommandBuilder setUUID(String uuid){
        this.bootCommand.add("-uuid " + uuid);
        return this;
    }

    /**
     * Block device options:
     * -fda/-fdb file  use 'file' as floppy disk 0/1 image
     * -hda/-hdb file  use 'file' as IDE hard disk 0/1 image
     * -hdc/-hdd file  use 'file' as IDE hard disk 2/3 image
     * -cdrom file     use 'file' as IDE cdrom image (cdrom is ide1 master)
     * -blockdev [driver=]driver[,node-name=N][,discard=ignore|unmap]
     *           [,cache.direct=on|off][,cache.no-flush=on|off]
     *           [,read-only=on|off][,auto-read-only=on|off]
     *           [,force-share=on|off][,detect-zeroes=on|off|unmap]
     *           [,driver specific parameters...]
     *                 configure a block backend
     * -drive [file=file][,if=type][,bus=n][,unit=m][,media=d][,index=i]
     *        [,cache=writethrough|writeback|none|directsync|unsafe][,format=f]
     *        [,snapshot=on|off][,rerror=ignore|stop|report]
     *        [,werror=ignore|stop|report|enospc][,id=name]
     *        [,aio=threads|native|io_uring]
     *        [,readonly=on|off][,copy-on-read=on|off]
     *        [,discard=ignore|unmap][,detect-zeroes=on|off|unmap]
     *        [[,bps=b]|[[,bps_rd=r][,bps_wr=w]]]
     *        [[,iops=i]|[[,iops_rd=r][,iops_wr=w]]]
     *        [[,bps_max=bm]|[[,bps_rd_max=rm][,bps_wr_max=wm]]]
     *        [[,iops_max=im]|[[,iops_rd_max=irm][,iops_wr_max=iwm]]]
     *        [[,iops_size=is]]
     *        [[,group=g]]
     *                 use 'file' as a drive image
     * -mtdblock file  use 'file' as on-board Flash memory image
     * -sd file        use 'file' as SecureDigital card image
     * -snapshot       write to temporary files instead of disk image files
     * -fsdev local,id=id,path=path,security_model=mapped-xattr|mapped-file|passthrough|none
     *  [,writeout=immediate][,readonly=on][,fmode=fmode][,dmode=dmode]
     *  [[,throttling.bps-total=b]|[[,throttling.bps-read=r][,throttling.bps-write=w]]]
     *  [[,throttling.iops-total=i]|[[,throttling.iops-read=r][,throttling.iops-write=w]]]
     *  [[,throttling.bps-total-max=bm]|[[,throttling.bps-read-max=rm][,throttling.bps-write-max=wm]]]
     *  [[,throttling.iops-total-max=im]|[[,throttling.iops-read-max=irm][,throttling.iops-write-max=iwm]]]
     *  [[,throttling.iops-size=is]]
     * -fsdev proxy,id=id,socket=socket[,writeout=immediate][,readonly=on]
     * -fsdev proxy,id=id,sock_fd=sock_fd[,writeout=immediate][,readonly=on]
     * -fsdev synth,id=id
     * -virtfs local,path=path,mount_tag=tag,security_model=mapped-xattr|mapped-file|passthrough|none
     *         [,id=id][,writeout=immediate][,readonly=on][,fmode=fmode][,dmode=dmode][,multidevs=remap|forbid|warn]
     * -virtfs proxy,mount_tag=tag,socket=socket[,id=id][,writeout=immediate][,readonly=on]
     * -virtfs proxy,mount_tag=tag,sock_fd=sock_fd[,id=id][,writeout=immediate][,readonly=on]
     * -virtfs synth,mount_tag=tag[,id=id][,readonly=on]
     * -iscsi [user=user][,password=password]
     *        [,header-digest=CRC32C|CR32C-NONE|NONE-CRC32C|NONE
     *        [,initiator-name=initiator-iqn][,id=target-iqn]
     *        [,timeout=timeout]
     *                 iSCSI session parameters
     * */

    public BootCommandBuilder setFda(String file){
        this.bootCommand.add("-fda \"" + file + "\"");
        return this;
    }

    public BootCommandBuilder setFdb(String file){
        this.bootCommand.add("-fdb \"" + file + "\"");
        return this;
    }

    public BootCommandBuilder setHda(String file){
        this.bootCommand.add("-hda \"" + file + "\"");
        return this;
    }

    public BootCommandBuilder setHdb(String file){
        this.bootCommand.add("-hdb \"" + file + "\"");
        return this;
    }

    public BootCommandBuilder setHdc(String file){
        this.bootCommand.add("-hdc \"" + file + "\"");
        return this;
    }

    public BootCommandBuilder setHdd(String file){
        this.bootCommand.add("-hdd \"" + file + "\"");
        return this;
    }

    public BootCommandBuilder setCdrom(String file){
        this.bootCommand.add("-cdrom \"" + file + "\"");
        return this;
    }

    public BootCommandBuilder setBlockdev(String driver, String node_name, String discard, String cache_direct, String cache_no_flush, String read_only, String auto_read_only, String force_share, String detect_zeroes, String driver_specific_parameters){
        this.bootCommand.add("-blockdev driver=" + driver + ",node-name=" + node_name + ",discard=" + discard + ",cache.direct=" + cache_direct + ",cache.no-flush=" + cache_no_flush + ",read-only=" + read_only + ",auto-read-only=" + auto_read_only + ",force-share=" + force_share + ",detect-zeroes=" + detect_zeroes + ",driver specific parameters=" + driver_specific_parameters);
        return this;
    }

    public BootCommandBuilder setBlockDev(String args){
        this.bootCommand.add("-blockdev " + args);
        return this;
    }

    public BootCommandBuilder setDrive(String args){
        this.bootCommand.add("-drive " + args);
        return this;
    }

    public BootCommandBuilder setMtdBlock(String file){
        this.bootCommand.add("-mtdblock \"" + file + "\"");
        return this;
    }

    public BootCommandBuilder setSd(String file){
        this.bootCommand.add("-sd \"" + file + "\"");
        return this;
    }

    public BootCommandBuilder setSnapshot(){
        this.bootCommand.add("-snapshot");
        return this;
    }

    public BootCommandBuilder setFsDev(String args){
        this.bootCommand.add("-fsdev " + args);
        return this;
    }

    public BootCommandBuilder setVirtFs(String args){
        this.bootCommand.add("-virtfs " + args);
        return this;
    }

    /**USB convenience options:
     -usb            enable on-board USB host controller (if not enabled by default)
     -usbdevice name add the host or guest USB device 'name'

     Display options:
     -display spice-app[,gl=on|off]
     -display sdl[,gl=on|core|es|off][,grab-mod=<mod>][,show-cursor=on|off]
     [,window-close=on|off]
     -display gtk[,full-screen=on|off][,gl=on|off][,grab-on-hover=on|off]
     [,show-tabs=on|off][,show-cursor=on|off][,window-close=on|off]
     [,show-menubar=on|off]
     -display vnc=<display>[,<optargs>]
     -display curses[,charset=<encoding>]
     -display egl-headless[,rendernode=<file>]
     -display none
     select display backend type
     The default display is equivalent to
     "-display gtk"
     -nographic      disable graphical output and redirect serial I/Os to console
     -spice [port=port][,tls-port=secured-port][,x509-dir=<dir>]
     [,x509-key-file=<file>][,x509-key-password=<file>]
     [,x509-cert-file=<file>][,x509-cacert-file=<file>]
     [,x509-dh-key-file=<file>][,addr=addr]
     [,ipv4=on|off][,ipv6=on|off][,unix=on|off]
     [,tls-ciphers=<list>]
     [,tls-channel=[main|display|cursor|inputs|record|playback]]
     [,plaintext-channel=[main|display|cursor|inputs|record|playback]]
     [,sasl=on|off][,disable-ticketing=on|off]
     [,password=<string>][,password-secret=<secret-id>]
     [,image-compression=[auto_glz|auto_lz|quic|glz|lz|off]]
     [,jpeg-wan-compression=[auto|never|always]]
     [,zlib-glz-wan-compression=[auto|never|always]]
     [,streaming-video=[off|all|filter]][,disable-copy-paste=on|off]
     [,disable-agent-file-xfer=on|off][,agent-mouse=[on|off]]
     [,playback-compression=[on|off]][,seamless-migration=[on|off]]
     [,gl=[on|off]][,rendernode=<file>]
     enable spice
     at least one of {port, tls-port} is mandatory
     -portrait       rotate graphical output 90 deg left (only PXA LCD)
     -rotate <deg>   rotate graphical output some deg left (only PXA LCD)
     -vga [std|cirrus|vmware|qxl|xenfb|tcx|cg3|virtio|none]
     select video card type
     -full-screen    start in full screen
     -vnc <display>  shorthand for -display vnc=<display>
     * */

    public BootCommandBuilder setUSB(){
        this.bootCommand.add("-usb");
        return this;
    }

    public BootCommandBuilder setUSBDevice(String name){
        this.bootCommand.add("-usbdevice " + name);
        return this;
    }
    public BootCommandBuilder setDisplay(String args){
        this.bootCommand.add("-display " + args);
        return this;
    }

    public BootCommandBuilder setDisplaySpiceApp(boolean gl){
        this.bootCommand.add("-display spice-app,gl=" + QemuTypes.getBoolean(gl));
        return this;
    }

    public BootCommandBuilder setDisplaySdl(boolean gl, String grabMod, boolean showCursor, boolean windowClose){
        this.bootCommand.add("-display sdl,gl=" + QemuTypes.getBoolean(gl) + ",grab-mod=" + grabMod + ",show-cursor=" + QemuTypes.getBoolean(showCursor) + ",window-close=" + QemuTypes.getBoolean(windowClose));
        return this;
    }

    public BootCommandBuilder setDisplayGtk(boolean fullScreen, boolean gl, boolean grabOnHover, boolean showTabs, boolean showCursor, boolean windowClose, boolean showMenubar){
        this.bootCommand.add("-display gtk,full-screen=" + QemuTypes.getBoolean(fullScreen) + ",gl=" + QemuTypes.getBoolean(gl) + ",grab-on-hover=" + QemuTypes.getBoolean(grabOnHover) + ",show-tabs=" + QemuTypes.getBoolean(showTabs) + ",show-cursor=" + QemuTypes.getBoolean(showCursor) + ",window-close=" + QemuTypes.getBoolean(windowClose) + ",show-menubar=" + QemuTypes.getBoolean(showMenubar));
        return this;
    }

    public BootCommandBuilder setDisplayVnc(String display, String optargs){
        this.bootCommand.add("-display vnc=" + display + "," + optargs);
        return this;
    }

    public BootCommandBuilder setDisplayCurses(String charset){
        this.bootCommand.add("-display curses,charset=" + charset);
        return this;
    }

    public BootCommandBuilder setDisplayEglHeadless(String rendernode){
        this.bootCommand.add("-display egl-headless,rendernode=" + rendernode);
        return this;
    }

    public BootCommandBuilder setDisplayNone(){
        this.bootCommand.add("-display none");
        return this;
    }

    public BootCommandBuilder setNoGraphic(){
        this.bootCommand.add("-nographic");
        return this;
    }

    public BootCommandBuilder setSpice(String args){
        this.bootCommand.add("-spice " + args);
        return this;
    }

    public BootCommandBuilder setPortrait(){
        this.bootCommand.add("-portrait");
        return this;
    }

    public BootCommandBuilder setRotate(int deg){
        this.bootCommand.add("-rotate " + deg);
        return this;
    }

    public BootCommandBuilder setVga(QemuTypes.VgaType type){
        this.bootCommand.add("-vga " + type.toString());
        return this;
    }

    public BootCommandBuilder setFullScreen(){
        this.bootCommand.add("-full-screen");
        return this;
    }

    public BootCommandBuilder setVNC(String display){
        this.bootCommand.add("-vnc " + display);
        return this;
    }


    /**Network options:
     -netdev user,id=str[,ipv4=on|off][,net=addr[/mask]][,host=addr]
     [,ipv6=on|off][,ipv6-net=addr[/int]][,ipv6-host=addr]
     [,restrict=on|off][,hostname=host][,dhcpstart=addr]
     [,dns=addr][,ipv6-dns=addr][,dnssearch=domain][,domainname=domain]
     [,tftp=dir][,tftp-server-name=name][,bootfile=f][,hostfwd=rule][,guestfwd=rule]                configure a user mode network backend with ID 'str',
     its DHCP server and optional services
     -netdev tap,id=str,ifname=name
     configure a host TAP network backend with ID 'str'
     -netdev socket,id=str[,fd=h][,listen=[host]:port][,connect=host:port]
     configure a network backend to connect to another network
     using a socket connection
     -netdev socket,id=str[,fd=h][,mcast=maddr:port[,localaddr=addr]]
     configure a network backend to connect to a multicast maddr and port
     use 'localaddr=addr' to specify the host address to send packets from
     -netdev socket,id=str[,fd=h][,udp=host:port][,localaddr=host:port]
     configure a network backend to connect to another network
     using an UDP tunnel
     -netdev stream,id=str[,server=on|off],addr.type=inet,addr.host=host,addr.port=port[,to=maxport][,numeric=on|off][,keep-alive=on|off][,mptcp=on|off][,addr.ipv4=on|off][,addr.ipv6=on|off]
     -netdev stream,id=str[,server=on|off],addr.type=unix,addr.path=path[,abstract=on|off][,tight=on|off]
     -netdev stream,id=str[,server=on|off],addr.type=fd,addr.str=file-descriptor
     configure a network backend to connect to another network
     using a socket connection in stream mode.
     -netdev dgram,id=str,remote.type=inet,remote.host=maddr,remote.port=port[,local.type=inet,local.host=addr]
     -netdev dgram,id=str,remote.type=inet,remote.host=maddr,remote.port=port[,local.type=fd,local.str=file-descriptor]
     configure a network backend to connect to a multicast maddr and port
     use ``local.host=addr`` to specify the host address to send packets from
     -netdev dgram,id=str,local.type=inet,local.host=addr,local.port=port[,remote.type=inet,remote.host=addr,remote.port=port]
     -netdev dgram,id=str,local.type=unix,local.path=path[,remote.type=unix,remote.path=path]
     -netdev dgram,id=str,local.type=fd,local.str=file-descriptor
     configure a network backend to connect to another network
     using an UDP tunnel
     -netdev hubport,id=str,hubid=n[,netdev=nd]
     configure a hub port on the hub with ID 'n'
     -nic [tap|bridge|user|socket][,option][,...][mac=macaddr]
     initialize an on-board / default host NIC (using MAC address
     macaddr) and connect it to the given host network backend
     -nic none       use it alone to have zero network devices (the default is to
     provided a 'user' network connection)
     -net nic[,macaddr=mac][,model=type][,name=str][,addr=str][,vectors=v]
     configure or create an on-board (or machine default) NIC and
     connect it to hub 0 (please use -nic unless you need a hub)
     -net [user|tap|bridge|socket][,option][,option][,...]
     old way to initialize a host network interface
     (use the -netdev option if possible instead)

     * */

    public BootCommandBuilder setNetDev(String args){
        this.bootCommand.add("-netdev " + args);
        return this;
    }
    public BootCommandBuilder setUserNetwork(String id, String args){
        this.bootCommand.add("-netdev user,id=" + id + "," + args);
        return this;
    }

    public BootCommandBuilder setUserNetworkWithForwarding(String id,PortForwarding forwarding){
        if(forwarding.ForwardingMap.isEmpty()){
            this.bootCommand.add("-netdev user,id=" + id);
        }else{
            this.bootCommand.add("-netdev user,id=" + id + "," + forwarding.getHostfwdString());
        }
        return this;
    }

    public BootCommandBuilder setNet(String args){
        this.bootCommand.add("-net " + args);
        return this;
    }

    public BootCommandBuilder setNic(String args){
        this.bootCommand.add("-nic " + args);
        return this;
    }

    public BootCommandBuilder setNicNone(){
        this.bootCommand.add("-nic none");
        return this;
    }

    /**Character device options:
     -chardev help
     -chardev null,id=id[,mux=on|off][,logfile=PATH][,logappend=on|off]
     -chardev socket,id=id[,host=host],port=port[,to=to][,ipv4=on|off][,ipv6=on|off][,nodelay=on|off]
     [,server=on|off][,wait=on|off][,telnet=on|off][,websocket=on|off][,reconnect=seconds][,mux=on|off]
     [,logfile=PATH][,logappend=on|off][,tls-creds=ID][,tls-authz=ID] (tcp)
     -chardev socket,id=id,path=path[,server=on|off][,wait=on|off][,telnet=on|off][,websocket=on|off][,reconnect=seconds]
     [,mux=on|off][,logfile=PATH][,logappend=on|off][,abstract=on|off][,tight=on|off] (unix)
     -chardev udp,id=id[,host=host],port=port[,localaddr=localaddr]
     [,localport=localport][,ipv4=on|off][,ipv6=on|off][,mux=on|off]
     [,logfile=PATH][,logappend=on|off]
     -chardev msmouse,id=id[,mux=on|off][,logfile=PATH][,logappend=on|off]
     -chardev vc,id=id[[,width=width][,height=height]][[,cols=cols][,rows=rows]]
     [,mux=on|off][,logfile=PATH][,logappend=on|off]
     -chardev ringbuf,id=id[,size=size][,logfile=PATH][,logappend=on|off]
     -chardev file,id=id,path=path[,mux=on|off][,logfile=PATH][,logappend=on|off]
     -chardev pipe,id=id,path=path[,mux=on|off][,logfile=PATH][,logappend=on|off]
     -chardev console,id=id[,mux=on|off][,logfile=PATH][,logappend=on|off]
     -chardev serial,id=id,path=path[,mux=on|off][,logfile=PATH][,logappend=on|off]
     -chardev braille,id=id[,mux=on|off][,logfile=PATH][,logappend=on|off]
     -chardev spicevmc,id=id,name=name[,debug=debug][,logfile=PATH][,logappend=on|off]
     -chardev spiceport,id=id,name=name[,debug=debug][,logfile=PATH][,logappend=on|off]
     */

    public BootCommandBuilder setCharDev(String args){
        this.bootCommand.add("-chardev " + args);
        return this;
    }

    /**Boot Image or Kernel specific:
     -bios file      set the filename for the BIOS
     -pflash file    use 'file' as a parallel flash image
     -kernel bzImage use 'bzImage' as kernel image
     -append cmdline use 'cmdline' as kernel command line
     -initrd file    use 'file' as initial ram disk
     -dtb    file    use 'file' as device tree image

     * */

    public BootCommandBuilder setBios(String path){
        this.bootCommand.add("-bios \"" + path + "\"");
        return this;
    }

    public BootCommandBuilder setPFlash(String path){
        this.bootCommand.add("-pflash \"" + path + "\"");
        return this;
    }

    public BootCommandBuilder setKernel(String path){
        this.bootCommand.add("-kernel \"" + path + "\"");
        return this;
    }

    public BootCommandBuilder setAppend(String args){
        this.bootCommand.add("-append \"" + args + "\"");
        return this;
    }

    public BootCommandBuilder setInitrd(String path){
        this.bootCommand.add("-initrd \"" + path + "\"");
        return this;
    }

    public BootCommandBuilder setDtb(String path){
        this.bootCommand.add("-dtb \"" + path + "\"");
        return this;
    }


/**
 * -drive [file=file][,if=type][,bus=n][,unit=m][,media=d][,index=i]
 *        [,cache=writethrough|writeback|none|directsync|unsafe][,format=f]
 *        [,snapshot=on|off][,rerror=ignore|stop|report]
 *        [,werror=ignore|stop|report|enospc][,id=name]
 *        [,aio=threads|native|io_uring]
 *        [,readonly=on|off][,copy-on-read=on|off]
 *        [,discard=ignore|unmap][,detect-zeroes=on|off|unmap]
 *        [[,bps=b]|[[,bps_rd=r][,bps_wr=w]]]
 *        [[,iops=i]|[[,iops_rd=r][,iops_wr=w]]]
 *        [[,bps_max=bm]|[[,bps_rd_max=rm][,bps_wr_max=wm]]]
 *        [[,iops_max=im]|[[,iops_rd_max=irm][,iops_wr_max=iwm]]]
 *        [[,iops_size=is]]
 *        [[,group=g]]
 */


    public BootCommandBuilder addCdromDrive(String path,String id, QemuTypes.DiskFormat format,QemuTypes.CacheMode cache){
        this.bootCommand.add("-drive file=\"" + path + "\",id=" + id + ",format=" + format.toString() + ",cache=" + cache.toString() + ",media=cdrom,if=none");
        return this;
    }

    public BootCommandBuilder addDiskDrive(String path,String id, QemuTypes.DiskFormat format,QemuTypes.CacheMode cache){
        this.bootCommand.add("-drive file=\"" + path + "\",id=" + id + ",format=" + format.toString() + ",cache=" + cache.toString() + ",media=disk,if=none");
        return this;
    }

    public BootCommandBuilder addDrive(String path,String id, QemuTypes.DiskFormat format,QemuTypes.CacheMode cache,String media){
        this.bootCommand.add("-drive file=\"" + path + "\",id=" + id + ",format=" + format.toString() + ",cache=" + cache.toString() + ",media=" + media + ",if=none");
        return this;
    }

    public BootCommandBuilder addDrive(String path,String id, QemuTypes.DiskFormat format,QemuTypes.CacheMode cache,String media,String p_if){
        this.bootCommand.add("-drive file=\"" + path + "\",id=" + id + ",format=" + format.toString() + ",cache=" + cache.toString() + ",media=" + media + ",if=" + p_if);
        return this;
    }

    public BootCommandBuilder addUserNetwork(String id, String args){
        return this.setUserNetwork(id,args);
    }

    public BootCommandBuilder addUserNetworkWithForwarding(String id,PortForwarding forwarding){
        return this.setUserNetworkWithForwarding(id,forwarding);
    }





















































}
