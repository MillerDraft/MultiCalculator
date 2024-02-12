import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ModernCal extends Calculator{
    public ModernCal() {
        super();
    }

    @Override
    public void setFrame() {
        super.setFrame();
        frame = new JFrame("Modern Calculator");
        frame.setSize(420, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void setTextField() {
        super.setTextField();
    }

    @Override
    public void setPanel() {
        super.setPanel();
    }

    @Override
    public void setMyFont(Font myFont) {
        super.setMyFont(myFont);
    }

    @Override
    public void addComponentsToFrame() {
        super.addComponentsToFrame();
    }

    @Override
    public void setButtons() {
        super.setButtons();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }
}