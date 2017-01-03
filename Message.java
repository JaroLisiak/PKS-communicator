package komunikator;

import java.io.Serializable;

public class Message implements Serializable{

    public short ID;
    public short maxPocet;
    public short type; // 01 = sprava, 02 = subor , 03 = ukonci spojenie
    public byte[] data;
    public int crc;

    public Message(int poradie, int type, byte[] data) { // datova hlavicka
        this.ID = (short) poradie;
        this.data = data;
        this.crc = getCRC(this.data);
    }
    
    public Message(int type){
        this.type = (short) type;
    }

    public Message(int poradie, int type, int fragSize, byte[] data, int maxPocet) { // prva hlavicka SUBOR
        this.ID = (short) poradie;
        this.type = (short) type;
        this.maxPocet = (short) maxPocet;
        this.data = data;
        this.crc = getCRC(this.data);
    }

    public Message(int poradie, int type, int fragSize, int maxPocet) { // prva hlavicka TEXT
        this.type = (short) type;
        this.ID = (short) poradie;
        this.maxPocet = (short) maxPocet;
    }

    public Message(short type) {
        this.type = type;
    }

    public static int getCRC(byte[] data) {
        int newCRC = 0;
        int tmp;

        for (int i = 0; i < data.length; i++) {
            tmp = newCRC << 1;
            tmp += 0xff & data[i];
            newCRC = (tmp & 0xff) + (tmp >> 8) & 0xff;
        }
        return (newCRC);
    }
}
