//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Controller responsible for managing the stories and their interactions with the user interface.
// *
// * @author javiergs
// */
//
//public class StoriesNanny {
//
//	public StoriesNanny() {
//
//	}
//
//	public void saveAndAddNew(String text) {
//        Blackboard bb = Blackboard.getInstance();
//		System.out.println(text);
//        bb.addNewStory(text);
//		// add functionality to save the story and add a new one
//	}
//
//	public void saveAndClose(String text) {
//        Blackboard bb = Blackboard.getInstance();
//        System.out.println(text);
//        bb.addNewStory(text);
//		Blackboard.addNewStory(text);
//	}
//
//	public void importStories() {
//		System.out.println("importing stories...");
//	}
//
//	public void cancel() {
//		System.out.println("canceling...");
//	}
//
////	private void switchGUI() {
////		main.setTitle("dashboard");
////		DashboardNanny dashboardNanny = new DashboardNanny(main);
////		DashboardPanel dashboardPanel = new DashboardPanel(dashboardNanny);
////		main.setContentPane(dashboardPanel);
////		main.setSize(800, 600);
////		main.setLocationRelativeTo(null);
////		main.revalidate();
////		main.repaint();
////	}
//
//}
//
//
