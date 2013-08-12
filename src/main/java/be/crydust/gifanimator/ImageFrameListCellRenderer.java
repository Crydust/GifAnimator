package be.crydust.gifanimator;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

/**
 *
 * @author kristof
 */
public class ImageFrameListCellRenderer extends JLabel implements ListCellRenderer {

    public static final String TEXT_FORMAT = "Frame #%s";
    public static final int COMPONENT_WIDTH = 160;
    public static final int COMPONENT_HEIGHT = 140;
    public static final int THUMBNAIL_WIDTH = 144;
    public static final int THUMBNAIL_HEIGHT = 108;
    public static final int ICON_TEXT_GAP = 5;
    public static final int FONT_SIZE = 10;
    public static final int VERTICAL_MARGIN = (COMPONENT_HEIGHT - THUMBNAIL_HEIGHT - ICON_TEXT_GAP - FONT_SIZE) / 2;
    public static final int HORIZONTAL_MARGIN = (COMPONENT_WIDTH - THUMBNAIL_WIDTH) / 2;

    public ImageFrameListCellRenderer() {
        this.setPreferredSize(new Dimension(160, 140));
        this.setBorder(BorderFactory.createEmptyBorder(VERTICAL_MARGIN, HORIZONTAL_MARGIN, 0, HORIZONTAL_MARGIN));
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.setIconTextGap(ICON_TEXT_GAP);
        this.setFont(this.getFont().deriveFont(FONT_SIZE));
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        String text = String.format(TEXT_FORMAT, index + 1);
        this.setText(text);
        if (value instanceof ImageFrame) {
            ImageFrame imageFrame = (ImageFrame) value;
            BufferedImage image = imageFrame.getImage();

            double width = imageFrame.getWidth();
            double height = imageFrame.getHeight();
            double scale = Math.min(THUMBNAIL_WIDTH / width, THUMBNAIL_HEIGHT / height);
            if (scale > 1.0) {
                scale = 1.0;
            }
            width *= scale;
            height *= scale;

            ImageIcon thumbnail = new ImageIcon(image.getScaledInstance((int) width, (int) height, Image.SCALE_FAST));
            this.setIcon(thumbnail);
        } else {
            this.setIcon(null);
        }
        return this;
    }
}
