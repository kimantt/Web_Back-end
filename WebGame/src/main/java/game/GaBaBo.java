package game;

public class GaBaBo extends Game<GaBaBo.GaBaBoResultPack> {
	// 가위바위보 게임
	
	// 상수 정의
	private final String[] choices = {"가위", "바위", "보"};
	private int computerChoice;
	private int playerInput; // 플레이어 입력값
	
	public GaBaBo(int playerInput) {
		this.playerInput = playerInput;
		this.computerChoice = random.nextInt(3);
	}
	
	// 게임 실행
	@Override
	public GaBaBoResultPack run() {
		GaBaBoResultPack resultSet = null;
		
		// 입력값 검증
		if (playerInput < 0 || playerInput > 2) return null;
		
		// 승패 판단
		if (playerInput == computerChoice) {
			resultSet = new GaBaBoResultPack(choices[computerChoice], "비겼습니다!");
		} else if ((playerInput == 0 && computerChoice == 2) ||
				(playerInput == 1 && computerChoice == 0) ||
				(playerInput == 2 && computerChoice == 1)) {
			resultSet = new GaBaBoResultPack(choices[computerChoice], "당신이 이겼습니다^^");
		} else {
			resultSet = new GaBaBoResultPack(choices[computerChoice], "컴퓨터가 이겼습니다...");
		}
		
		return resultSet;
	}
	
	public class GaBaBoResultPack {
		public final String computerChoice;
		public final String result;
		
		public GaBaBoResultPack(String computerChoice, String result) {
			this.computerChoice = computerChoice;
			this.result = result;
		}
	}
}
