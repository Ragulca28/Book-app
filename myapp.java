import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;//for adding file

public class myapp {
    private JFrame frame1;
    private JFrame frame2;
    private JFrame frame3;
	 private JFrame frame4;//1st
    private JFrame frame5;//2nd
    private JFrame frame6;//3rd
	private JFrame Frame7;//fileReaderButton
	private JFrame frame8;//4th
    private JFrame frame9;//5th
    private JFrame frame10;//6th
    private JFrame frame3e;
    private JTextField studentNameField;
    private JTextField collegeCodeField;

    public myapp() {
        // Frame 1
       	   frame1 = new JFrame("Frame 1");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500, 500);
        frame1.setLayout(new FlowLayout());
		//frame1.setLayout(BorderLayout(500,500));

        // Image adder
		ImageIcon i = new ImageIcon("D:/system folders/Downloads/welcome.jpeg");
        JLabel imageLabel = new JLabel(i,SwingConstants.HORIZONTAL);
        frame1.add(imageLabel);

      

        // Cancel button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame1.add(cancelButton);

  // Next button
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                createFrame2();
            }
        });
        frame1.add(nextButton);

        frame1.setVisible(true);
    }

    private void createFrame2() {
        // Frame 2
	
        frame2 = new JFrame("Frame 2");
    
    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(450, 500);
		//frame2.setLayout(new BorderLayout(10,30));
        frame2.setLayout(new FlowLayout());
		
		//JLabel background = new JLabel(new ImageIcon("C:/Users/C.A.RAGUL/OneDrive/Pictures/Screenshots/Screenshot 2023-04-19 075408.png"));
//frame2.setContentPane(background);
//frame2.setLayout(new FlowLayout());

        // Student name field
        studentNameField = new JTextField(10);
        frame2.add(new JLabel("Student Name:"));
		frame2.add(studentNameField,BorderLayout.NORTH);
       // frame2.add(studentNameField);
		

        //College code field
        collegeCodeField = new JTextField(10);
        frame2.add(new JLabel("College Code:"));
        frame2.add(collegeCodeField,BorderLayout.NORTH);

       

        // Previous button
        JButton previousButton = new JButton("Previous");
		previousButton.setBounds(300,350,50,50);
        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(false);
                frame1.setVisible(true);
            }
        });
        

frame2.add(previousButton);
 // Next button
        JButton nextButton = new JButton("Next");
			nextButton.setBounds(200, 350, 50, 50);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String collegeCode = collegeCodeField.getText();
				//string studentNameField = studentnamef.getText();
                if (collegeCode.equals("Anm103")) {
                    frame2.setVisible(false);
                    createFrame3();
                }
				else {
					
					createFrame3e();
				}
				
            }
        });
		Dimension size = nextButton.getPreferredSize();
	
        frame2.add(nextButton);

        frame2.setVisible(true);
    }

    private void createFrame3() {
      // Frame 3
      frame3 = new JFrame("Frame 3");
      frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame3.setSize(500, 500);
      frame3.setLayout(new FlowLayout());
JLabel yearlabel = new JLabel("Enter the Semester: ");	 
frame3.add(yearlabel);
      // Buttons 1, 2, and 3
      for (int i = 1; i <= 6; i++) {
          JButton button = new JButton(Integer.toString(i));
		  int finalI= i;
          button.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
				 if(finalI  == 1)
				 {
					 createframe4();
					 System.out.println("2021");
                  // Do something when buttons are clicked
              }
			  else if(finalI==2)
			  {
				   System.out.println("2022");
			  createframe5();
			  }
			  else if(finalI == 3)
			  {
				   System.out.println("2023");
				  //createteFrame6();
			  }
			  
			  }
	});
	frame3.add(button);
	  }
  //button 1
		  		     
JLabel textlabel = new JLabel("click next button to add your files");	 
frame3.add(textlabel);
      // Next button
      JButton nextButton = new JButton("Next");
      nextButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              createFrame7();
              frame3.setVisible(false);
          }
      });
      frame3.add(nextButton);

      // Previous button
      JButton previousButton = new JButton("Previous");
      previousButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              frame3.setVisible(false);
              frame2.setVisible(true);
          }
      });
      frame3.add(previousButton);

      frame3.setVisible(true);
    }
   //1st sem
    private void createframe4() {
    frame4 = new JFrame("1st sem books");
    frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame4.setSize(500, 500);
    frame4.setLayout(new BorderLayout());

    // Add year label
    JLabel yearlabel = new JLabel("Enter the year:");
    frame4.add(yearlabel, BorderLayout.NORTH);

    // Add buttons panel
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
    frame4.add(buttonsPanel, BorderLayout.CENTER);
 final int y = 2021; // make y effectively final
    for (int i = 1; i <= 3; i++) {
		int z = y + i - 1;
        JButton yearButton = new JButton(Integer.toString(z));
        yearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("E:/Book app/EBOOKs/2nd sem/"+z);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files", "pdf");
                fileChooser.setFileFilter(filter);
                int returnVal = fileChooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        Desktop.getDesktop().open(selectedFile);
                    } catch (IOException ex) {
                        System.out.println("Error opening file: " + ex.getMessage());
                    }
                }
            }
        });
        buttonsPanel.add(yearButton);
    }

    // Add previous button
    JButton previousButton = new JButton("Previous");
    previousButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            frame4.setVisible(false);
        }
    });
    frame4.add(previousButton, BorderLayout.SOUTH);

    // Show frame 5
    frame4.setVisible(true);
}
    //2nd sem
       private void createframe5() {
    frame5 = new JFrame("2nd sem books");
    frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame5.setSize(500, 500);
    frame5.setLayout(new BorderLayout());

    // Add year label
    JLabel yearlabel = new JLabel("Enter the year:");
    frame5.add(yearlabel, BorderLayout.NORTH);

    // Add buttons panel
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
    frame5.add(buttonsPanel, BorderLayout.CENTER);
 final int y = 2021; // make y effectively final
    for (int i = 1; i <= 3; i++) {
		int z = y + i - 1;
        JButton yearButton = new JButton(Integer.toString(z));
        yearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("E:/Book app/EBOOKs/2nd sem/"+z);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files", "pdf");
                fileChooser.setFileFilter(filter);
                int returnVal = fileChooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        Desktop.getDesktop().open(selectedFile);
                    } catch (IOException ex) {
                        System.out.println("Error opening file: " + ex.getMessage());
                    }
                }
            }
        });
        buttonsPanel.add(yearButton);
    }

    // Add previous button
    JButton previousButton = new JButton("Previous");
    previousButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            frame5.setVisible(false);
        }
    });
    frame5.add(previousButton, BorderLayout.SOUTH);

    // Show frame 5
    frame5.setVisible(true);
}

	//frame for displying the text files
	private void createFrame3e() {
      // Frame 3e error
      frame3e = new JFrame("Frame 3e");
	  JLabel nameLabele = new JLabel("you have  entered the wrong college code ! ");	 
	  // Frame 3[error message]
	  frame3e.add(nameLabele);
      frame3e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame3e.setSize(500, 500);
	   
	 // frame3e.setLayout(new FlowLayout());
      // Show Frame 3e
     
	    JButton prevButton1 = new JButton("Previous");
        prevButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame3e.setVisible(false);
                frame2.setVisible(true);
            }
        });
		frame3e.setLayout(new BoxLayout(frame3e.getContentPane(), BoxLayout.Y_AXIS));
    nameLabele.setAlignmentX(Component.CENTER_ALIGNMENT);
    prevButton1.setAlignmentX(Component.CENTER_ALIGNMENT);

		frame3e.add(prevButton1);
		 frame3e.setVisible(true);
	}
	//frame for reading text files
    private void createFrame7() {
      // Frame 7
      Frame7 = new JFrame("Frame File adder");
      Frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Frame7.setSize(500, 500);
      Frame7.setLayout(new FlowLayout());

      // File inserter and file reader buttons
      JButton fileInserterButton = new JButton("File Inserter");
      fileInserterButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              // Do something when file inserter button is clicked
          }
      });
      Frame7.add(fileInserterButton);
/*
      JButton fileReaderButton = new JButton("File Reader");
      fileReaderButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              // Do something when file reader button is clicked
          }
      });
      Frame7.add(fileReaderButton); */

      // Previous button
      JButton previousButton = new JButton("Previous");
      previousButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
               Frame7.setVisible(false);
                frame3.setVisible(true);
            }
        });
        Frame7.add(previousButton); 

        // Close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
			});
        Frame7.add(closeButton);
        Frame7.setVisible(true);
    }

    public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              new myapp();
          }
      });
    }
}