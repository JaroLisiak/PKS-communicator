package komunikator;

import java.io.Serializable;

public class Odpoved implements Serializable {
	public short id; //Poradie fragmentu
	public short type; //4 = CRC je dobre, 1 = CRC nie je dobre
	
	public Odpoved(short id, short type) {
	 this.id = id;
	 this.type = type;
	}
}
