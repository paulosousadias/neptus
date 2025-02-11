/*
 * Copyright (c) 2004-2023 Universidade do Porto - Faculdade de Engenharia
 * Laboratório de Sistemas e Tecnologia Subaquática (LSTS)
 * All rights reserved.
 * Rua Dr. Roberto Frias s/n, sala I203, 4200-465 Porto, Portugal
 *
 * This file is part of Neptus, Command and Control Framework.
 *
 * Commercial Licence Usage
 * Licencees holding valid commercial Neptus licences may use this file
 * in accordance with the commercial licence agreement provided with the
 * Software or, alternatively, in accordance with the terms contained in a
 * written agreement between you and Universidade do Porto. For licensing
 * terms, conditions, and further information contact lsts@fe.up.pt.
 *
 * Modified European Union Public Licence - EUPL v.1.1 Usage
 * Alternatively, this file may be used under the terms of the Modified EUPL,
 * Version 1.1 only (the "Licence"), appearing in the file LICENSE.md
 * included in the packaging of this file. You may not use this work
 * except in compliance with the Licence. Unless required by applicable
 * law or agreed to in writing, software distributed under the Licence is
 * distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF
 * ANY KIND, either express or implied. See the Licence for the specific
 * language governing permissions and limitations at
 * https://github.com/LSTS/neptus/blob/develop/LICENSE.md
 * and http://ec.europa.eu/idabc/eupl.html.
 *
 * For more information please see <http://lsts.fe.up.pt/neptus>.
 *
 * Author: zp
 * Dec 21, 2015
 */
package pt.lsts.neptus.util.credentials;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.l2fprod.common.beans.editor.AbstractPropertyEditor;

import pt.lsts.neptus.i18n.I18n;

/**
 * @author zp
 *
 */
public class CredentialsEditor extends AbstractPropertyEditor {

    protected JTextField textField = new JTextField();
    private JButton button = new JButton(I18n.text("Edit"));
    private Credentials credentials = null;

    public CredentialsEditor() {
        editor = new JPanel(new BorderLayout(0, 0));
        ((JPanel) editor).add(button, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                credentials.showDialog(SwingUtilities.getRoot(button), I18n.text("Enter Credentials"));
            }
        });
    }

    public Object getValue() {
        return credentials;
    }

    public void setValue(Object arg0) {
        if (arg0 instanceof Credentials) {
            this.credentials = (Credentials) arg0;
        }
    }
}
