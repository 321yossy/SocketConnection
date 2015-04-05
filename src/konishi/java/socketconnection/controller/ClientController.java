package konishi.java.socketconnection.controller;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import konishi.java.socketconnection.base.ControllerBase;
import konishi.java.socketconnection.main.TransmitClient;
import konishi.java.socketconnection.model.ReceiveModel;
import konishi.java.socketconnection.model.StoreData;


/**
 * クライアント側のコントローラーです。
 * 
 * @version 1.0.0
 * @author konishi
 * @see ServerController
 */
public class ClientController extends ControllerBase {
	
	@FXML public AnchorPane root_map;
	
	@FXML public Button connection_button;
	@FXML public Button disconnection_button;
	
	@FXML public Button front_camera_button;
	@FXML public Button back_camera_button;
	@FXML public Button arm_camera_button;
	
	@FXML public Button robot_map_button;
	@FXML public Button rabble_map_button;
	@FXML public Button doll_map_button;
	
	@FXML public Button l2_controller_button;
	@FXML public Button l1_controller_button;
	@FXML public Button r2_controller_button;
	@FXML public Button r1_controller_button;
	@FXML public Button right_controller_button;
	@FXML public Button left_controller_button;
	@FXML public Button up_controller_button;
	@FXML public Button down_controller_button;
	@FXML public Button circle_controller_button;
	@FXML public Button cross_controller_button;
	@FXML public Button triangle_controller_button;
	@FXML public Button rectangle_controller_button;
	
	@FXML public Button submit_button;
	
	private static final String MAP_FILE = StoreData.CLIENT_MAP_FILE;
	
	private TransmitClient client = null;
	
	/**
	 * 初期化処理を記述するメソッドです。
	 */
	public void init() throws Exception {
		client = new TransmitClient();
		
		setRootMap(root_map);
		client.clearFile(MAP_FILE);
		
		AnimationTimer timer = new AnimationTimer() {	
			@Override
			public void handle(long now) {
				mapPainter();
			}
		};
		timer.start();
	}
	
	/**
	 * マウスクリック時の動作を定義します。
	 * @param event マウスクリック時に受け取るイベント
	 */
	@FXML public void handleMouseAction(MouseEvent event) throws Exception {
		if (mapFrag != 0) {
			
			ReceiveModel.data = stringMapEventAgent(event);
			
			client.write(ReceiveModel.data);
			
			ReceiveModel.isUpdated = true;
		}
	}


	/**
	 * ボタンアクションを読み取ります。
	 * @param event イベントアクション
	 * @throws Exception エラー
	 */
	public void handleButtonAction(ActionEvent event) throws Exception {
		switch (getId(event.toString())) { 
		case "connection_button":
			connection_button.setText("Hello");
			init();
			break;
		case "disconnection_button":
			connection_button.setText("Connection");
			client.closeTransport();
			break;
			
		case "front_camera_button":
			break;
		case "back_camera_button":
			break;
		case "arm_camera_button":
			break;
			
		case "robot_map_button":
			if (mapFrag != 1)	mapFrag = 0;
			mapFrag ^= 1;
			break;
		case "rubble_map_button":
			if (mapFrag != 2)	mapFrag = 0;
			mapFrag ^= 2;
			break;
		case "doll_map_button":
			if (mapFrag != 3)	mapFrag = 0;
			mapFrag ^= 3;
			break;
			
		case "l2_controller_button":
			break;
		case "l1_controller_button":
			break;
		case "r2_controller_button":
			break;
		case "r1_controller_button":
			break;
		case "right_controller_button":
			break;
		case "left_controller_button":
			break;
		case "up_controller_button":
			break;
		case "down_controller_button":
			break;
		case "circle_controller_button":
			break;
		case "cross_controller_button":
			break;
		case "triangle_controller_button":
			break;
		case "rectangle_controller_button":
			break;
			
		case "submit_button":
			break;
		}
	}
}
