package com.example.ramen.menu;

/**
 * Created by ramen on 3/11/17.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


        import android.util.Log;
        import android.view.View;

        import com.example.ramen.menu.Model.Order;
        import com.example.ramen.menu.Model.SocketProperties;

        import java.io.IOException;
        import java.io.ObjectInputStream;
        import java.io.ObjectOutputStream;
        import java.net.InetAddress;
        import java.net.InetSocketAddress;
        import java.net.Socket;

//        import javax.swing.table.DefaultTableModel;

//        import Model.Order;

/**
 *
 * @author shreejal
 */
public class SocketClient implements Runnable{
    public int port;
    public String serverAddr;
    public Socket socket;
//    public View ui;
    public ObjectInputStream In;
    public ObjectOutputStream Out;

    public SocketClient() throws IOException{
//        ui = frame;
        this.serverAddr = SocketProperties.getIpAddress();
//        Log.i("info ","Ip: "+serverAddr);
        this.port = SocketProperties.getPortNumber();
//        Log.i("info ","port: "+port);
//        this.serverAddr = ui.serverAddr;
//        this.port = ui.port;
        socket = new Socket();
        socket.connect(new InetSocketAddress(serverAddr.trim(), port),5000);

        Out = new ObjectOutputStream(socket.getOutputStream());
        Out.flush();
        In = new ObjectInputStream(socket.getInputStream());

    }
    @Override
    public void run() {
        boolean keepRunning = true;
        while(keepRunning){
            try {
                Order msg = (Order) In.readObject();
                // System.out.println("Incoming : "+msg.toString());
//                DefaultTableModel table = (DefaultTableModel) ui.jTable1.getModel();
//                table.addRow(new Object[]{msg.getTableNo(),msg.getDishName(), msg.getQuantity(),msg.getStatus()});
            }catch(IOException | ClassNotFoundException e){
            }

        }
    }
    public void send(Order order){
        try {
            Out.writeObject(order);
            Out.flush();
            System.out.println("Outgoing : "+order.toString());


//                String msgTime = (new Date()).toString();
//                try{
//                   // hist.addMessage(msg, msgTime);
//                    //DefaultTableModel table = (DefaultTableModel) ui.historyFrame.jTable1.getModel();
//                    //table.addRow(new Object[]{"Me", msg.content, msg.recipient, msgTime});
//                }
//                catch(Exception ex){
//                JOptionPane.showMessageDialog(null, "exception sending mwssage");
//                }
        }
        catch (IOException ex) {
            System.out.println("Exception SocketClient send()");
        }
    }

    public void closeThread(Thread t){
        t = null;
    }

}
