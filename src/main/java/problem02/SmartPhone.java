package problem02;

public class SmartPhone extends MusicPhone {
	
	@Override
	public String playMusic() {
		// TODO Auto-generated method stub
		return "스트리밍";
	}
	
	@Override
	public void execute(String function) {
		if(function.equals("앱")) {
			System.out.println(runApp());
			return;
		}
		super.execute(function);
	}
	
	public String runApp() {
		
		return "앱실행";
	}
}