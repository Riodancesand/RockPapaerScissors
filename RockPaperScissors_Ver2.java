// メソッド分け

package original;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors_Ver2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//プレイヤー名を入力
		String name = getName();

		// 開始メッセージ
		startMessage();

		// じゃんけん
		runRockPaperScissors(name);

		// 終了メッセージ
		endMessage();
	}

	// プレイヤー名入力メソッド
	public static String getName() {
		Scanner stdin = new Scanner(System.in);
		System.out.print("あなたの名前を入力してください　＞＞");
		return stdin.next();
	}

	// 開始メッセージメソッド
	public static void startMessage() {
		System.out.println("----------------------------------");
		System.out.println("じゃんけんゲームを開始します");
		System.out.println("先に3勝したほうの勝利です");
	}

	// じゃんけんメソッド
	public static void runRockPaperScissors(String name) {
		Scanner stdin = new Scanner(System.in);
		int playerPoint = 0;
		int comPoint = 0;
		String playerHand = "";
		int playerHandNumber = 0;
		while (playerPoint < 3 && comPoint < 3) {
			// プレイヤーが出す手を入力
			System.out.println("----------------------------------");
			System.out.println(name + "さん、出す手を選んでください");
			System.out.print("0:✊ 1:✌️ 2:✋　＞＞️");
			String inputPlayerHand = stdin.next();
			switch (inputPlayerHand) {
			case "0":
				playerHand = "✊";
				playerHandNumber = 0;
				break;
			case "1":
				playerHand = "✌️";
				playerHandNumber = 1;
				break;
			case "2":
				playerHand = "✋";
				playerHandNumber = 2;
				break;
			default:
				System.out.println("不正な入力です");
				System.out.println("再度、入力してください");
				continue;
			}
			// comの出す手を生成
			String[] comHand = { "✊", "✌️", "✋" };
			Random rand = new Random();
			int i = rand.nextInt(3);

			// 互いの出した手を出力
			System.out.println("");
			System.out.println(name + "さん:" + playerHand + "vs com:" + comHand[i]);
			System.out.println("");

			// 勝敗判定
			if (playerHandNumber == 0 && i == 1) {
				playerPoint++;
			} else if (playerHandNumber == 1 && i == 2) {
				playerPoint++;
			} else if (playerHandNumber == 2 && i == 0) {
				playerPoint++;
			} else if (playerHandNumber == 1 && i == 0) {
				comPoint++;
			} else if (playerHandNumber == 2 && i == 1) {
				comPoint++;
			} else if (playerHandNumber == 0 && i == 2) {
				comPoint++;
			} else {
				System.out.println("あいこ");
				continue;
			}

			System.out.println(name + "さん:" + playerPoint + "　対　com:" + comPoint);
			continue;

		}

		// 結果発表
		System.out.println("----------------------------------");
		if (playerPoint == 3) {
			System.out.println("あなたの勝利！");
		} else if (comPoint == 3) {
			System.out.println("comの勝利！");
		}

	}

	// ゲーム終了メッセージメソッド
	public static void endMessage() {
		System.out.println("ゲームを終了します");
		System.out.println("----------------------------------");
	}

}
