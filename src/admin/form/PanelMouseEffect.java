/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin.form;

/**
 *
 * @author pande
 */


import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JComponent;

public class PanelMouseEffect extends JComponent {

    public final static Color[] colors = new Color[]{Color.decode("#FFC312"), Color.decode("#C4E538"), Color.decode("#12CBC4"), Color.decode("#FDA7DF"), Color.decode("#ED4C67"), Color.decode("#009432"), Color.decode("#0652DD"), Color.decode("#9980FA"), Color.decode("#006266")};
    private List<Effect> effectes;
    private Thread thread;
    private final int SHAPE_SIZE = 10;
    private Shape shape;

    public PanelMouseEffect() {
        setOpaque(true);
        setBackground(new Color(193, 193, 193));
    }

    public void registerMouseEffect() {
        initSubComponent(PanelMouseEffect.this);
        shape = createShape();
    }

    private Shape createShape() {
        Path2D p = new Path2D.Double();
        float size = SHAPE_SIZE;
        p.moveTo(0, 0.35 * size);
        p.lineTo(1 * size, 0.35 * size);
        p.lineTo(0.1 * size, 1 * size);
        p.lineTo(0.5 * size, 0);
        p.lineTo(0.9 * size, 1 * size);
        return p;
    }

    private void initSubComponent(JComponent com) {
        init(com);
        for (Component c : com.getComponents()) {
            if (c instanceof JComponent) {
                initSubComponent((JComponent) c);
            }
        }
    }

    private void init(JComponent com) {
        effectes = new ArrayList<>();
        MouseAdapter mouseEvent = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                addEffect(e.getLocationOnScreen());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                addEffect(e.getLocationOnScreen());
            }
        };
        com.addMouseMotionListener(mouseEvent);
    }

    public void addEffect(Point point) {
        effectes.add(new Effect(point));
        startThread();
        repaint();
    }

    private void startThread() {
        if (thread == null || !thread.isAlive()) {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!effectes.isEmpty()) {
                        for (int i = 0; i < effectes.size(); i++) {
                            Effect effect = effectes.get(i);
                            if (effect != null) {
                                effect.update();
                            }
                        }
                        repaint();
                        sleep();
                    }

                }
            });
            thread.start();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    private void removeEffect(Effect effect) {
        effectes.remove(effect);
        if (effectes.isEmpty()) {
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (isOpaque()) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (effectes != null) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            for (int i = 0; i < effectes.size(); i++) {
                Effect effect = effectes.get(i);
                if (effect != null) {
                    effect.render(g2);
                }
            }
            g2.dispose();
        }
    }

    private class Effect {

        private final static double MAX_DISTANCE = 50;
        private final static int SIZE = 1;
        private final static float SPEED = 0.5f;
        private final Point location;
        private double distance;
        private float[] angles;
        private Color[] colors;

        public Effect(Point location) {
            this.location = location;
            init();
        }

        private void init() {
            angles = new float[SIZE];
            colors = new Color[SIZE];
            int distanceAngle = 180;
            float initAngle = 90 - ((distanceAngle * SIZE) / 2);
            Random ran = new Random();
            for (int i = 0; i < angles.length; i++) {
                int angle = ran.nextInt(distanceAngle) + 1;
                angles[i] = initAngle + (distanceAngle * i) + angle;
                colors[i] = PanelMouseEffect.colors[ran.nextInt(PanelMouseEffect.colors.length)];
            }
        }

        public void update() {
            if (distance > MAX_DISTANCE) {
                removeEffect(this);
            } else {
                distance += SPEED;
            }
        }

        public void render(Graphics2D g2) {
            double alpha = distance / MAX_DISTANCE;
            if (alpha > 1f) {
                alpha = 1f;
            }
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) (1f - alpha)));
            for (int i = 0; i < angles.length; i++) {
                g2.setPaint(createPaint(colors[i]));
                AffineTransform tran = g2.getTransform();
                Point2D p = getLocationOf(angles[i]);
                g2.translate(p.getX(), p.getY());
                g2.rotate(Math.toRadians(distance * 5f), SHAPE_SIZE / 2, SHAPE_SIZE / 2);
                g2.fill(shape);
                g2.setTransform(tran);
            }

        }

        private Paint createPaint(Color color) {
            Point2D center = new Point2D.Double(SHAPE_SIZE / 2, SHAPE_SIZE / 2);
            float[] dist = {0.0f, 0.9f};
            Color[] cols = {color, Color.WHITE};
            Paint p = new RadialGradientPaint(center, SHAPE_SIZE, dist, cols);
            return p;
        }

        private Point2D getLocationOf(float angle) {
            Point p = getLocationOnScreen();
            double cosX = Math.cos(Math.toRadians(angle)) * distance;
            double sinY = Math.sin(Math.toRadians(angle)) * distance;
            return new Point2D.Double(location.getX() + cosX - p.getX(), location.getY() + sinY - p.getY());
        }
    }
}