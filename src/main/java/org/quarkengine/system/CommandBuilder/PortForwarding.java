package org.quarkengine.system.CommandBuilder;

import java.util.HashMap;
import java.util.List;

public class PortForwarding {
    public static enum NetworkProtocol{
        tcp,udp
    }
    public static class NetworkAddress{
        public NetworkProtocol protocol;
        public String ip;
        public int port;
        public NetworkAddress(NetworkProtocol protocol, String ip, int port){
            this.protocol = protocol;
            this.ip = ip;
            this.port = port;
        }
    }

    public HashMap<NetworkAddress,NetworkAddress> ForwardingMap = new HashMap<>();

    public void add(NetworkAddress host, NetworkAddress guest){
        ForwardingMap.put(host, guest);
    }

    public void add(NetworkProtocol protocol, String hostIp, int hostPort, String guestIp, int guestPort){
        NetworkAddress host = new NetworkAddress(protocol, hostIp, hostPort);
        NetworkAddress guest = new NetworkAddress(protocol, guestIp, guestPort);
        ForwardingMap.put(host, guest);
    }

    public String getHostfwdString(){
        StringBuilder sb = new StringBuilder();
        for(NetworkAddress host : ForwardingMap.keySet()){
            NetworkAddress guest = ForwardingMap.get(host);
            sb.append("hostfwd=");
            sb.append(host.protocol);
            sb.append(":");
            sb.append(host.ip);
            sb.append(":");
            sb.append(host.port);
            sb.append("-");
            sb.append(guest.ip);
            sb.append(":");
            sb.append(guest.port);
            sb.append(",");
        }
        //sb.substring(0, sb.length()-1);
        return sb.substring(0, sb.length()-1);
    }

    @Override
    public String toString() {
        return getHostfwdString();
    }


























}
