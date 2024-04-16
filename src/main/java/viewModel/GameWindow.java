package viewModel;

import view.View;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JInternalFrame
{
    public GameWindow(View view, ViewModel viewModel)
    {
        super("Игровое поле", true, true, true, true);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH; // Заполняем всю область
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 0;


        panel.add(viewModel, c);
        panel.add(view, c);

        getContentPane().add(panel);

        pack();
    }
}
