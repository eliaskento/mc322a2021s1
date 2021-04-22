package mc322.lab04;

public class appLab04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CSVReader csv = new CSVReader();
		csv.setDataSource("src/mc322/lab04/jogadas02.csv");
		String jogadas[] = csv.requestCommands();
		System.out.print(jogadas[0]);
		System.out.println();
		System.out.print(jogadas[1]);
	}

}
