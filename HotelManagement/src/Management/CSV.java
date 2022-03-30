package Management;


	import java.io.BufferedWriter;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Iterator;

	public class CSV {

		
		public static void downloadArchive() {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("archive.csv"));
				Iterator<Resident> i = ResidentCollection.residents.listIterator();
				Resident temp;
				while(i.hasNext()) {
					temp=i.next();
					writer.write(temp.getFname()+", "+temp.getLname()+", "+temp.getRoom().getNumber()+", "+temp.getRoom().getType().name());
					writer.newLine();
				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}
