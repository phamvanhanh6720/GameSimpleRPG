package projectoop.gui;

import projectoop.Game;
import projectoop.input.KeyBoard;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel implements IGameBoard{
    private static final String TAG_PLAYGAME="tag_playgame";
    private static final String TAG_OPTION="tag_option";
    private static final String TAG_MENU="tag_menu";
    private static final String TAG_HOWTOPLAY="tag_howtoplay";
    private static final String TAG_CHOOSELEVEL="tag_chooselevel";

    private CardLayout cardLayout;
    private GUI gui;
    private Menu menu;
    private PlayGame playGame;
    private HowToPlay howtoPlay;
    private ChooseLevel chooseLevel;
    private Option option;

    public GameBoard(GUI gui,Game game){
        this.gui=gui;
        setBackground(Color.WHITE);
        cardLayout=new CardLayout();
        setLayout(cardLayout);

        menu=new Menu(this);
        add(menu,TAG_MENU);

        playGame=new PlayGame(this);
        add(playGame,TAG_PLAYGAME);

        howtoPlay=new HowToPlay(this);
        add(howtoPlay,TAG_HOWTOPLAY);

        option=new Option(this);
        add(option,TAG_OPTION);

        chooseLevel=new ChooseLevel(this);
        add(chooseLevel,TAG_CHOOSELEVEL);

        setShowMenu();

    }
    public void setShowMenu(){
        cardLayout.show(this,TAG_MENU);
        menu.requestFocus();


    }
    public void setShowPlay(){
        cardLayout.show(this,TAG_PLAYGAME);
        playGame.repaint();
        playGame.requestFocus();

    }
    public void setShowOption(){
        cardLayout.show(this,TAG_OPTION);
        option.requestFocus();
    }

    public void setShowChoseLevel(){
        cardLayout.show(this,TAG_CHOOSELEVEL);
        chooseLevel.requestFocus();
    }

    public void setShowHowToPlay(){
        cardLayout.show(this,TAG_HOWTOPLAY);
        howtoPlay.requestFocus();

    }


    public GUI getGui() {
        return gui;
    }


}
