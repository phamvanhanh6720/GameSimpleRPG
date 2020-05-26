package projectoop.gui;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    private static final String TAG_PLAYGAME="tag_playgame";
    private static final String TAG_OPTION="tag_howtoplay";
    private static final String TAG_MENU="tag_menu";
    private CardLayout cardLayout;
    private GUI gui;
    private Menu menu;
    private PlayGame playGame;
    private Option option;

    public GameBoard(GUI gui){
        this.gui=gui;
        setBackground(Color.WHITE);
        cardLayout=new CardLayout();
        setLayout(cardLayout);

        menu=new Menu(this);
        add(menu,TAG_MENU);

        playGame=new PlayGame(this);
        add(playGame,TAG_PLAYGAME);

        option=new Option(this);
        add(option,TAG_OPTION);

        setShowMenu();

    }
    public void setShowMenu(){
        cardLayout.show(this,TAG_MENU);
        menu.requestFocus();


    }
    public void setShowPlay(){
        cardLayout.show(this,TAG_PLAYGAME);
        playGame.requestFocus();

    }
    public void setShowOption(){
        cardLayout.show(this,TAG_OPTION);
        option.requestFocus();

    }

    public GUI getGui() {
        return gui;
    }
}
