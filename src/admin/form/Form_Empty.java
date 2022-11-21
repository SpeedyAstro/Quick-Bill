package admin.form;

public class Form_Empty extends javax.swing.JPanel {

    public Form_Empty(String name) {
        initComponents();
        panelMouseEffect.registerMouseEffect();
        lb.setText("Form " + name);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMouseEffect1 = new admin.form.PanelMouseEffect();
        panelMouseEffect = new admin.form.PanelMouseEffect();
        lb = new javax.swing.JLabel();

        setOpaque(false);

        lb.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        lb.setForeground(new java.awt.Color(125, 125, 125));
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Form");
        panelMouseEffect.add(lb);
        lb.setBounds(0, 180, 702, 62);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMouseEffect, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMouseEffect, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb;
    private admin.form.PanelMouseEffect panelMouseEffect;
    private admin.form.PanelMouseEffect panelMouseEffect1;
    // End of variables declaration//GEN-END:variables
}
