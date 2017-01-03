package komunikator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaroslav Lišiak
 */
public class Control {
    public static void main(String args[]){
        Client client = new Client();
        Server server = new Server();
        client.setVisible(true);
        server.setVisible(true);   
}
    
}

