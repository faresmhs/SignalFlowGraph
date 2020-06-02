package controlProject;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JFrame frame;
    private JTextField textfieldfrom;
    private JTextField textfieldvertices;
    private JTextField textfieldedges;
    private JTextField textfieldendvertex;
    private JTextField textfieldstartvertex;
    private JTextField textfieldto;
    private JTextField textfieldweight;
    private JTextField textfieldtf;
    private int numb = 0;
    private int numv;
    private int nume;
    private int start;
    private int end;
    private ProjectGragh sfg;
    private int from;
    private int to;
    private double weight;
    private Graph sfggui = new MultiGraph("SFG.");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI window = new GUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public GUI(){
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(152, 80, 1135, 754);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JButton btnNewButton = new JButton("ADD");
        btnNewButton.setForeground(new Color(60, 63, 65));
        btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textfieldfrom.getText().equals("") || textfieldto.getText().equals("")
                        || textfieldweight.getText().equals("")) {
                    return;
                }
                from = Integer.valueOf(textfieldfrom.getText());
                to = Integer.valueOf(textfieldto.getText());
                weight = Double.valueOf(textfieldweight.getText());
                if (numv != 0 && (from > numv || from < 0 || to > numv || to < 0)) {
                    return;
                }
                if (numb == 0) {
                    if (textfieldvertices.getText().equals("") || textfieldedges.getText().equals("")
                            || textfieldstartvertex.getText().equals("") || textfieldendvertex.getText().equals("")) {
                        return;
                    }
                    numv = Integer.valueOf(textfieldvertices.getText());
                    if (from > numv || from < 0 || to > numv || to < 0) {
                        return;
                    }
                    for (int i = 1; i <= numv; i++) {
                        sfggui.addNode(Integer.toString(i));
                        sfggui.getNode(Integer.toString(i)).addAttribute("ui.label", Integer.toString(i));
                    }
                    nume = Integer.valueOf(textfieldedges.getText());
                    start = Integer.valueOf(textfieldstartvertex.getText());
                    end = Integer.valueOf(textfieldendvertex.getText());
                    sfg = new ProjectGragh(numv, start, end);
                    sfggui.addEdge(Integer.toString(from) + Integer.toString(to), Integer.toString(from),
                            Integer.toString(to), true);
                    sfggui.getEdge(Integer.toString(from) + Integer.toString(to)).addAttribute("ui.label",
                            Double.toString(weight));
                    sfg.addEdge(from, to, weight);
                    numb++;
                } else if (numb == nume) {
                    return;
                } else {
                    sfg.addEdge(from, to, weight);
                    sfggui.addEdge(Integer.toString(from) + Integer.toString(to), Integer.toString(from),
                            Integer.toString(to), true);
                    sfggui.getEdge(Integer.toString(from) + Integer.toString(to)).addAttribute("ui.label",
                            Double.toString(weight));
                    numb++;
                }

            }
        });
        btnNewButton.setBounds(250, 471, 81, 38);
        frame.getContentPane().add(btnNewButton);
        frame.setTitle("SignalFlowGraph");
        JLabel lblAddAnEdge = new JLabel("Add edges ");
        lblAddAnEdge.setForeground(new Color(60, 63, 65));
        lblAddAnEdge.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        lblAddAnEdge.setBounds(10, 361, 216, 49);
        frame.getContentPane().add(lblAddAnEdge);

        textfieldfrom = new JTextField();
        textfieldfrom.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        textfieldfrom.setBounds(0, 471, 60, 40);
        frame.getContentPane().add(textfieldfrom);
        textfieldfrom.setColumns(10);

        JLabel lblNumOfVertices = new JLabel("Vertices num:");
        lblNumOfVertices.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lblNumOfVertices.setBounds(10, 100, 141, 34);
        frame.getContentPane().add(lblNumOfVertices);

        textfieldvertices = new JTextField();
        textfieldvertices.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        textfieldvertices.setColumns(10);
        textfieldvertices.setBounds(161, 100, 114, 32);
        frame.getContentPane().add(textfieldvertices);

        textfieldedges = new JTextField();
        textfieldedges.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        textfieldedges.setColumns(10);
        textfieldedges.setBounds(161, 170, 114, 32);
        frame.getContentPane().add(textfieldedges);

        JLabel lblNumOfEdges = new JLabel("Edges num");
        lblNumOfEdges.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lblNumOfEdges.setBounds(20, 170, 187, 34);
        frame.getContentPane().add(lblNumOfEdges);

        JLabel lblNumOfStart = new JLabel("Start vertex num:");
        lblNumOfStart.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lblNumOfStart.setBounds(10, 235, 250, 34);
        frame.getContentPane().add(lblNumOfStart);

        JLabel lblNumOfEnd = new JLabel("End vertex num:");
        lblNumOfEnd.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lblNumOfEnd.setBounds(10, 308, 250, 34);
        frame.getContentPane().add(lblNumOfEnd);

        textfieldendvertex = new JTextField();
        textfieldendvertex.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        textfieldendvertex.setColumns(10);
        textfieldendvertex.setBounds(218, 308, 114, 32);
        frame.getContentPane().add(textfieldendvertex);

        textfieldstartvertex = new JTextField();
        textfieldstartvertex.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        textfieldstartvertex.setColumns(10);
        textfieldstartvertex.setBounds(218, 235, 114, 32);
        frame.getContentPane().add(textfieldstartvertex);

        textfieldto = new JTextField();
        textfieldto.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        textfieldto.setColumns(10);
        textfieldto.setBounds(85, 471, 60, 40);
        frame.getContentPane().add(textfieldto);

        textfieldweight = new JTextField();
        textfieldweight.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        textfieldweight.setColumns(10);
        textfieldweight.setBounds(171, 471, 60, 40);
        frame.getContentPane().add(textfieldweight);

        JLabel lblFrom = new JLabel("From");
        lblFrom.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lblFrom.setBounds(10, 420, 99, 40);
        frame.getContentPane().add(lblFrom);

        JLabel lblTo = new JLabel("To");
        lblTo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lblTo.setBounds(85, 421, 99, 40);
        frame.getContentPane().add(lblTo);

        JLabel lblWeight = new JLabel("Weight");
        lblWeight.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lblWeight.setBounds(161, 421, 99, 40);
        frame.getContentPane().add(lblWeight);

        JButton btnNewButton_1 = new JButton("Transfer Function\r\n\r\n");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sfg == null) {
                    return;
                }
                textfieldtf.setText(Double.toString(sfg.solveSFG()));
            }
        });
        btnNewButton_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setForeground(new Color(60, 63, 65));
        btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        btnNewButton_1.setBounds(10, 550, 239, 40);
        frame.getContentPane().add(btnNewButton_1);


        JLabel label_1 = new JLabel("Signal Flow Gragh \r\n");
        label_1.setForeground(new Color(0, 64, 128));
        label_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD , 40));
        label_1.setBounds(10, -11, 350, 109);
        frame.getContentPane().add(label_1);

        textfieldtf = new JTextField();
        textfieldtf.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        textfieldtf.setColumns(10);
        textfieldtf.setBounds(10, 600, 280, 40);
        frame.getContentPane().add(textfieldtf);

        Viewer viewer = sfggui.display();
        viewer.addDefaultView(false);
        View view = viewer.getDefaultView();
        frame.getContentPane().add((Component) view);
        ((Component) view).setBounds(350, 0, 770, 720);

        JButton btnNewGraph = new JButton("New graph");
        btnNewGraph.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sfg = null;
                sfggui.clear();
                textfieldfrom.setText("");
                textfieldto.setText("");
                textfieldweight.setText("");
                textfieldvertices.setText("");
                textfieldedges.setText("");
                textfieldstartvertex.setText("");
                textfieldendvertex.setText("");
                textfieldtf.setText("");
                numb = 0;
                JOptionPane.showMessageDialog(null, "Start writing your graph info.", "",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnNewGraph.setForeground(new Color(60, 63, 65));
        btnNewGraph.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnNewGraph.setBackground(Color.white);
        btnNewGraph.setBounds(10, 650, 163, 38);
        frame.getContentPane().add(btnNewGraph);

    }

}