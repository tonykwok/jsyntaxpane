/*
 * Copyright 2008 Ayman Al-Sairafi ayman.alsairafi@gmail.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License 
 *       at http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.  
 */
package jsyntaxpane;

import java.awt.Color;
import java.awt.Frame;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import jsyntaxpane.actions.FindReplaceActions;
import jsyntaxpane.actions.Markers;

/**
 *
 * @author Ayman Al-Sairafi
 */
public class ReplaceDialog extends javax.swing.JDialog {

    private SyntaxDocument document;
    private JTextComponent textComponent;
    private FindReplaceActions finder;
    private static Markers.SimpleMarker SEARCH_MARKER = new Markers.SimpleMarker(Color.GREEN);

    /** Creates new form FindDialog */
    public ReplaceDialog(Frame parent, SyntaxDocument doc, JTextComponent text,
            FindReplaceActions finderActions) {
        super(parent, false);
        document = doc;
        textComponent = text;
        finder = finderActions;
        initComponents();
    }

    // Creates highlights around all occurrences of pattern in textComp
    public void markString(JTextComponent textComp, String pattern) {
        // First remove all old highlights
        Markers.removeMarkers(textComponent, SEARCH_MARKER);
        // FIXME: replace this with Segment to avoid allocating data
        // or use the document's indexOf
        try {
            SyntaxDocument sDoc = (SyntaxDocument) textComp.getDocument();
            String text = sDoc.getText(0, sDoc.getLength());
            int pos = 0;

            // Search for pattern
            int len = pattern.length();
            while ((pos = text.indexOf(pattern, pos)) >= 0) {
                // Create highlighter using private painter and apply around pattern
                Markers.markText(textComp, pos, pos + len, SEARCH_MARKER);
                pos += len;
            }
        } catch (BadLocationException e) {
        }
    }

    /**
     * update the finder object with data from our UI
     */
    private void updateFinder() {
        int flag = 0;
        if (!jChkRegex.isSelected()) {
            flag |= Pattern.LITERAL;
        }
        flag |= (jChkIgnoreCase.isSelected()) ? Pattern.CASE_INSENSITIVE : 0;
        if (jChkIgnoreCase.isSelected()) {
            flag |= Pattern.CASE_INSENSITIVE;
        }
        Pattern pattern = Pattern.compile(jTxtFindText.getText(), flag);
        finder.setWrap(jChkWrap.isSelected());
        finder.setPattern(pattern);
    }

    /** 
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtFindText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBtnNext = new javax.swing.JButton();
        jLblStatus = new javax.swing.JLabel();
        jBtnReplaceAll = new javax.swing.JButton();
        jChkWrap = new javax.swing.JCheckBox();
        jChkRegex = new javax.swing.JCheckBox();
        jChkIgnoreCase = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jTxtReplacement = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Find");
        setResizable(false);

        jLabel1.setText("Find");

        jBtnNext.setMnemonic('N');
        jBtnNext.setText("Next");
        jBtnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNextActionPerformed(evt);
            }
        });

        jBtnReplaceAll.setMnemonic('H');
        jBtnReplaceAll.setText("Replace All");
        jBtnReplaceAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnReplaceAllActionPerformed(evt);
            }
        });

        jChkWrap.setMnemonic('W');
        jChkWrap.setText("Wrap around");
        jChkWrap.setToolTipText("Wrap to beginning when end is reached");

        jChkRegex.setMnemonic('R');
        jChkRegex.setText("Regular Expression");

        jChkIgnoreCase.setMnemonic('I');
        jChkIgnoreCase.setText("Ignore Case");

        jLabel2.setText("Replace");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTxtReplacement, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTxtFindText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jChkRegex)
                            .addComponent(jChkIgnoreCase))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(jLblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                .addGap(3, 3, 3))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jChkWrap, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnReplaceAll, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(jBtnNext, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLblStatus))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jTxtFindText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBtnNext))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTxtReplacement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnReplaceAll))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jChkRegex)
                            .addComponent(jChkWrap, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jChkIgnoreCase)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNextActionPerformed
        try {
            updateFinder();
            finder.doFindNext(textComponent);
            textComponent.requestFocusInWindow();
        } catch (PatternSyntaxException ex) {
            JOptionPane.showMessageDialog(this, "Regexp error: " + ex.getMessage(),
                    "Find", JOptionPane.ERROR_MESSAGE);
            jTxtFindText.requestFocus();
        }
    }//GEN-LAST:event_jBtnNextActionPerformed

    private void jBtnReplaceAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnReplaceAllActionPerformed
        String replacement = jTxtReplacement.getText();
        try {
            updateFinder();
            finder.replaceAll(textComponent, replacement);
            textComponent.requestFocusInWindow();
        } catch (PatternSyntaxException ex) {
            JOptionPane.showMessageDialog(this, "Regexp error: " + ex.getMessage(),
                    "Find", JOptionPane.ERROR_MESSAGE);
            jTxtFindText.requestFocus();
        }
}//GEN-LAST:event_jBtnReplaceAllActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnNext;
    private javax.swing.JButton jBtnReplaceAll;
    private javax.swing.JCheckBox jChkIgnoreCase;
    private javax.swing.JCheckBox jChkRegex;
    private javax.swing.JCheckBox jChkWrap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLblStatus;
    private javax.swing.JTextField jTxtFindText;
    private javax.swing.JTextField jTxtReplacement;
    // End of variables declaration//GEN-END:variables
}
