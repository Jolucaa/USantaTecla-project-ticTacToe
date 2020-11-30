package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Error;
import usantatecla.tictactoe.views.ErrorView;
import usantatecla.utils.ClosedInterval;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class CoordinatePutView extends CoordinateView {

    private Coordinate coordinate;

    CoordinatePutView() {
        super();
        this.resetCoordinate();
        this.titleLabel = new JLabel(ENTER_COORDINATE_TO_PUT);
        this.add(titleLabel, new Constraints(0, 0, 1, 1));
        this.button = new JButton(CoordinateView.ACCEPT);
        this.add(button, new Constraints(0, 5, 1, 1));
        this.button.addActionListener(this);
        this.button.addKeyListener(this);

    }

    void resetCoordinate() {
        this.coordinate = null;
    }

    Coordinate getCoordinate() {
        return this.coordinate;
    }

    public void actionPerformed(final ActionEvent event) {
        Coordinate coordinateInserted = new Coordinate(Integer.parseInt(this.textFieldRow.getText()) - 1,
                Integer.parseInt(this.textFieldColumn.getText()) - 1);
        Error error;
        ClosedInterval limits = new ClosedInterval(0, Coordinate.DIMENSION - 1);
        if (!limits.isIncluded(coordinateInserted.getRow()) || !limits.isIncluded(coordinateInserted.getColumn())) {
            error = Error.NOT_VALID;
        } else {
            error = Error.NULL;
        }
        if (error.isNull()) {
            this.coordinate = new Coordinate(coordinateInserted.getColumn(), coordinateInserted.getRow());
        } else {
            JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[error.ordinal()], "ERROR",
                    JOptionPane.WARNING_MESSAGE);
        }
        this.textFieldRow.setText("");
        this.textFieldColumn.setText("");
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

}