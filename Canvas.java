// WAHEGURU
//IK ONKAR SATGUR PRASAD

//import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.net.URL;
public class Canvas extends JFrame implements Serializable {
    ArrayList<Rectangle> ex = new ArrayList<>();
    ArrayList<Rectangle> exf = new ArrayList<>();
    ArrayList<Rectangle> exd = new ArrayList<>();
    JFrame f;
    JPanel c;
    JPanel p;
    JPanel q;
    Point o;
    int g=1;
    JLabel je;
    Canvas(){
        f=new JFrame("2D Floor Planner");
        f.setLayout(null);
        JLabel js=new JLabel("2D Floor Planner",SwingConstants.CENTER);
        f.setSize(1650,1080);
        
        js.setBounds(0,20,1435,50);
        js.setBackground(Color.white);
        js.setForeground(Color.BLACK);
        js.setFont(new Font("Arial", Font.PLAIN, 25));
        f.getContentPane().setBackground(Color.BLACK);
        js.setOpaque(true);

        p=new JPanel();
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.setBounds(20,150,300,500);
        String[] c1={"LIVING ROOM","DINING ROOM","BATHROOM"};
       
        
        String[] s={"ADD ROOM>","FURNITURE>","ADD DOOR","ADD WINDOW","SAVE FILE","LOAD FILE","EDIT","CLEAR"};
        JButton[] b=new JButton[s.length];
        for(int i=0;i<s.length;i++){
            b[i]=new JButton(s[i]);
            b[i].add(Box.createHorizontalGlue());
            b[i].add(Box.createVerticalGlue());
            b[i].setFont(new Font("Times New Roman", Font.ITALIC, 15));
            b[i].setSize(250,50);
            p.add(b[i]);
        }
        JPopupMenu m1=new JPopupMenu();
                JPopupMenu m2=new JPopupMenu();  
                m1.add("BEDROOM").addActionListener(new ActionListener() {
                    int i1,i2;
                    public void actionPerformed(ActionEvent e){
                        JFrame r1=new JFrame("ADD BEDROOM");
                        r1.setSize(500,500);
                        
                        
                        JTextField tf1=new JTextField();
                        tf1.setBounds(50,200,100,30);
                        JTextField tf2=new JTextField();
                        tf2.setBounds(50,300,100,30);
                        JLabel l1=new JLabel("Enter length of bedroom");
                        JLabel l2=new JLabel("Enter width of bedroom");
                        l1.setBounds(100,150,200,25);
                        l2.setBounds(100,250,200,25);
                        JButton b=new JButton("Enter");
                        b.setBounds(50,400,100,30);
                        b.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                i1=Integer.parseInt(tf1.getText());
                                i2=Integer.parseInt(tf2.getText());
                                if(check(i1,i2)){
                                Addroom a=new Addroom(i1,i2,1);
                                drawroom(a);
                                r1.dispose();
                                }
                                else
                                {
                                    r1.dispose();
                                }
                            }
                        });
                        r1.add(tf1);
                        r1.add(tf2);
                        r1.add(b);
                        r1.add(l1);
                        r1.add(l2);
                        r1.setLayout(null);
                        r1.setVisible(true);
                    
                    }
                });
                m1.add("KITCHEN").addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        JFrame r1=new JFrame("ADD KITCHEN");
                        r1.setSize(500,500);
                        JTextField tf1=new JTextField();
                        tf1.setBounds(50,200,100,30);
                        JTextField tf2=new JTextField();
                        tf2.setBounds(50,300,100,30);
                        JLabel l1=new JLabel("Enter length of kitchen");
                        JLabel l2=new JLabel("Enter width of kitchen");
                        l1.setBounds(100,150,200,25);
                        l2.setBounds(100,250,200,25);
                        JButton b=new JButton("Enter");
                        b.setBounds(50,400,100,30);
                        b.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                int i=Integer.parseInt(tf1.getText());
                                int j=Integer.parseInt(tf2.getText());
                                if(check(i,j)){
                                Addroom a=new Addroom(i,j,2);
                                drawroom(a);}
                                r1.dispose();
                            }
                        });
                        r1.add(tf1);
                        r1.add(tf2);
                        r1.add(b);
                        r1.add(l1);
                        r1.add(l2);
                        r1.setLayout(null);
                        r1.setVisible(true);
                    
                    }
                });
                m1.add("BATHROOM").addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        JFrame r1=new JFrame("ADD BATHROOM");
                        r1.setSize(500,500);
                        JTextField tf1=new JTextField();
                        tf1.setBounds(50,200,100,30);
                        JTextField tf2=new JTextField();
                        tf2.setBounds(50,300,100,30);
                        JLabel l1=new JLabel("Enter length of bathroom");
                        JLabel l2=new JLabel("Enter width of bathroom");
                        l1.setBounds(100,150,200,25);
                        l2.setBounds(100,250,200,25);
                        JButton b=new JButton("Enter");
                        b.setBounds(50,400,100,30);
                        b.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                int i=Integer.parseInt(tf1.getText());
                                int j=Integer.parseInt(tf2.getText());
                                if(check(i, j)){
                                Addroom a=new Addroom(i,j,3);
                                drawroom(a);
                                }
                                r1.dispose();
                            }
                        });
                        r1.add(tf1);
                        r1.add(tf2);
                        r1.add(b);
                        r1.add(l1);
                        r1.add(l2);
                        r1.setLayout(null);
                        r1.setVisible(true);
                       
                    }
                });
                m2.add("BED").addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        JFrame r1=new JFrame("ADD BED");
                        r1.setSize(500,500);
                        JTextField tf1=new JTextField();
                        tf1.setBounds(50,200,100,30);
                        JTextField tf2=new JTextField();
                        tf2.setBounds(50,300,100,30);
                        JLabel l1=new JLabel("Enter length of bed");
                        JLabel l2=new JLabel("Enter width of bed");
                        l1.setBounds(100,150,200,25);
                        l2.setBounds(100,250,200,25);
                        JButton b=new JButton("Enter");
                        b.setBounds(50,400,100,30);
                        b.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                int i=Integer.parseInt(tf1.getText());
                                int j=Integer.parseInt(tf2.getText());
                                if(check(i,j)){
                               Addfurniture d=new Addfurniture(i, j, 1);
                               drawFurniture(d);
                                }
                                r1.dispose();
                            }
                        });
                        r1.add(tf1);
                        r1.add(tf2);
                        r1.add(b);
                        r1.add(l1);
                        r1.add(l2);
                        r1.setLayout(null);
                        r1.setVisible(true);
                        
                    }
                });
                m2.add("DINING TABLE").addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        JFrame r1=new JFrame("ADD DINING TABLE");
                        r1.setSize(500,500);
                        JTextField tf1=new JTextField();
                        tf1.setBounds(50,200,100,30);
                        JTextField tf2=new JTextField();
                        tf2.setBounds(50,300,100,30);
                        JLabel l1=new JLabel("Enter length of dining table");
                        JLabel l2=new JLabel("Enter width of dining table");
                        l1.setBounds(100,150,200,25);
                        l2.setBounds(100,250,200,25);
                        JButton b=new JButton("Enter");
                        b.setBounds(50,400,100,30);
                        b.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                int i=Integer.parseInt(tf1.getText());
                                int j=Integer.parseInt(tf2.getText());
                                if(check(i, j)){
                                Addfurniture d=new Addfurniture(i, j, 2);
                                drawFurniture(d);
                                }
                                r1.dispose();
                            }
                        });
                        r1.add(tf1);
                        r1.add(tf2);
                        r1.add(b);
                        r1.add(l1);
                        r1.add(l2);
                        r1.setLayout(null);
                        r1.setVisible(true);
                 
                    }
                });
                m2.add("WASH BASIN").addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        JFrame r1=new JFrame("ADD WASH BASIN");
                        r1.setSize(500,500);
                        JTextField tf1=new JTextField();
                        tf1.setBounds(50,200,100,30);
                        JTextField tf2=new JTextField();
                        tf2.setBounds(50,300,100,30);
                        JLabel l1=new JLabel("Enter length of wash basin");
                        JLabel l2=new JLabel("Enter width of wash basin");
                        l1.setBounds(100,150,200,25);
                        l2.setBounds(100,250,200,25);
                        JButton b=new JButton("Enter");
                        b.setBounds(50,400,100,30);
                        b.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                
                                    int i = Integer.parseInt(tf1.getText());
                                    int j = Integer.parseInt(tf2.getText());
                                    if(check(i,j)){
                                    Addfurniture d = new Addfurniture(i, j, 3);
                                    drawFurniture(d);
                                    }
                                    r1.dispose();
                            }
                        });
                        r1.add(tf1);
                        r1.add(tf2);
                        r1.add(b);
                        r1.add(l1);
                        r1.add(l2);
                        r1.setLayout(null);
                        r1.setVisible(true);
                    }
                });
               
        b[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                m1.show(f,320,150);
            }
        });
        b[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                m2.show(f,320,230);
            }
        });
        b[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame r1=new JFrame("ADD DOOR");
                r1.setSize(500,500);
                JLabel z=new JLabel("Enter the width of the door");
                z.setBounds(50,50,200,50);
                JButton b=new JButton("Enter");
                b.setBounds(50,400,100,50);
                JTextField tf1=new JTextField();
                tf1.setBounds(50,100,100,50);
                
                JPopupMenu m1=new JPopupMenu();
                m1.add("Horizontal").addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        g=1;
                    }
                });
                m1.add("Vertical").addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        g=2;
                    }
                });
                JButton bo=new JButton("Orientation");
                bo.setBounds(50,350,100,50);
                bo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        m1.show(r1,50,300);
                    }
                });
                r1.add(bo);
                r1.add(z);
                r1.add(b);
                r1.add(tf1);
                r1.setVisible(true);
                r1.setDefaultCloseOperation(EXIT_ON_CLOSE);
                r1.setLayout(null);
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        int w=Integer.parseInt(tf1.getText());
                        if(w%20==0&&w>0){
                            AddDoorWindow d=new AddDoorWindow(w,1,g);
                            drawDoorWindow(d);
                            r1.dispose();
                        }
                    }
                });
            }
        });
        b[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame r1=new JFrame("ADD WINDOW");
                r1.setSize(300,300);
                JLabel z=new JLabel("Enter the width of the window");
                z.setBounds(50,50,200,50);
                JButton b=new JButton("Enter");
                b.setBounds(50,200,100,50);
                JTextField tf1=new JTextField();
                tf1.setBounds(50,100,100,50);
                JPopupMenu m1=new JPopupMenu();
                m1.add("Horizontal").addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        g=1;
                    }
                });
                m1.add("Vertical").addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        g=2;
                    }
                });
                JButton bo=new JButton("Orientation");
                bo.setBounds(50,350,100,50);
                bo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        m1.show(r1,50,300);
                    }
                });
                r1.add(bo);
                r1.add(z);
                r1.add(b);
                r1.add(tf1);
                r1.setVisible(true);
                r1.setDefaultCloseOperation(EXIT_ON_CLOSE);
                r1.setLayout(null);
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        int w=Integer.parseInt(tf1.getText());
                        if(w%20==0&&w>0){
                            AddDoorWindow d=new AddDoorWindow(w,2,g);
                            drawDoorWindow(d);
                            r1.dispose();
                        }
                    }
                });
            }
        });
        b[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                saveLayout();
            }
        });
        b[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                loadLayout();
            }
        });
        b[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(!(c.getComponentAt(0,0) instanceof JLabel))
                JOptionPane.showMessageDialog(f,"Drag the item you wish to edit to the top-left corner and then click on EDIT");
                else
                edit((JLabel)c.getComponentAt(0,0));
            }
        });
        b[s.length-1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ex.clear();
                exf.clear();
                exd.clear();
                c.removeAll();
                c.revalidate();
                c.repaint();
            }
        });
        
        c=new JPanel();
        c.setBounds(450,80,950,800);
        c.setLayout(null);
        c.setBorder(new LineBorder(Color.BLACK));
        c.setBackground(Color.WHITE);
        c.setOpaque(true);

        //c.add(q);
        f.add(c);
        //f.add(q);
        f.add(js);
        f.add(p);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
       }
       public boolean check(int i,int j){
        if(i>=20&&j>=20&&i%20==0&&j%20==0)
        return true;
        else
        return false;
       }
       public boolean overlaps(Rectangle target, List<Rectangle> list, boolean allowContain, boolean skipSelf) {
            for (Rectangle existing : list) {
                if (skipSelf && existing.equals(target)) continue;
                if (!allowContain && target.intersects(existing)) return true;
                if (allowContain && target.intersects(existing) && !target.contains(existing)) return true;
            }
            return false;
        }

       public void drawroom(Addroom a) {
        JLabel j = new JLabel();
        //j.setSize(a.x, a.y); // Set size based on the dimensions of the room
        switch (a.t) {
            case 1: j.setBackground(Color.RED); break; // Bedroom
            case 2: j.setBackground(Color.GREEN); break; // Kitchen
            case 3: j.setBackground(Color.BLUE); break; // Bathroom
        }
        j.setBorder(new LineBorder(Color.BLACK));
        j.setOpaque(true);
        j.setBounds(0,0,a.x,a.y);
        // Add to the q panel
        c.add(j);
        c.revalidate();
        c.repaint();
    
        // Add drag-and-drop functionality
        dragndrop(j,1);
    
        // Refresh the layout of the parent container
        c.revalidate();
        c.repaint();
    }
    
public void drawFurniture(Addfurniture d){
    ImageIcon hi = new ImageIcon();
    String path = "";

    switch(d.t){
        case 1: path = "/Resources/BedOOPS.png"; break;
        case 2: path = "/Resources/diningtable.png"; break;
        case 3: path = "/Resources/washbasin.jpg"; break;
    }

    if (!path.isEmpty()) {
        hi = new ImageIcon(this.getClass().getResource(path));
        Image image = hi.getImage();
        Image newImage = image.getScaledInstance(d.x, d.y, Image.SCALE_DEFAULT);

        ImageIcon h = new ImageIcon(newImage);
        h.setDescription(path);  // ✅ This line ensures the icon path is saved

        JLabel j = new JLabel();
        j.setIcon(h);
        j.setBounds(0, 0, d.x, d.y);
        c.add(j);
        c.setComponentZOrder(j, 0);
        c.setOpaque(true);
        c.revalidate();
        c.repaint();

        dragndrop(j, 2);
    }
}

       public void drawDoorWindow(AddDoorWindow d){
        JLabel j=new JLabel();
        j.setBounds(0,0,d.l,d.w);
        j.setBackground(Color.white);
        if(d.t==1){
            j.setBorder(new LineBorder(Color.black));
        }
        else
        {
            float dash[] = {5.0f}; // Dash size of 5 units
        Border dashedBorder = BorderFactory.createStrokeBorder(
            new BasicStroke(
                1.0f,                      // Border width
                BasicStroke.CAP_BUTT,      // End cap style
                BasicStroke.JOIN_BEVEL,    // Join style
                1.0f,                      // Miter limit
                dash,                      // Dash array
                0.0f                       // Dash phase
            ),
            Color.BLUE                    // Border color
        );
        // Set the dashed border to the JLabel
        j.setBorder(dashedBorder);
        }
        c.add(j);
        c.setComponentZOrder(j, 0);
        c.setOpaque(true);
        c.revalidate();
        c.repaint();
        dragndrop(j,3);
        c.revalidate();
        c.repaint();
       }
       
       public void dragndrop(JLabel j,int n) {
        final Point[] offset = {null}; // Store the offset between the click point and the JLabel's top-left corner
    
        j.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Calculate the offset between the JLabel's top-left corner and the click point
                offset[0] = new Point(e.getX(), e.getY());
    
                // Remove the current JLabel's bounds from `ex` to allow it to move freely
                if(n==1)
                ex.removeIf(existing -> existing.equals(j.getBounds()));
                else
                if(n==2)
                exf.removeIf(existing -> existing.equals(j.getBounds()));
                else
                if(n==3)
                exd.removeIf(existing -> existing.equals(j.getBounds()));
            }
    
            @Override
            public void mouseReleased(MouseEvent e) {
                // Snap the JLabel to the nearest 20px grid point on release
                Point currentLocation = j.getLocation();
                int snappedX = currentLocation.x - (currentLocation.x % 20);
                int snappedY = currentLocation.y - (currentLocation.y % 20);
    
                // Ensure the JLabel stays within the bounds of the panel
                snappedX = Math.max(0, Math.min(snappedX, c.getWidth() - j.getWidth()));
                snappedY = Math.max(0, Math.min(snappedY, c.getHeight() - j.getHeight()));
    
                j.setLocation(snappedX, snappedY);
                // Check for overlap with other JLabels
                Rectangle jb = new Rectangle(j.getBounds());
                boolean overlap = false;
                switch(n){

                case 1: // room
                    if (overlaps(jb, ex, false, true) || overlaps(jb, exf, true, true) || overlaps(jb, exd, true, true))
                    overlap = true;
                break;

            case 2: // furniture
                if (overlaps(jb, ex, true, true) || overlaps(jb, exf, false, true) || overlaps(jb, exd, true, true))
                overlap = true;
            break;
            case 3:{ // door/window
            if (overlaps(jb, ex, true, true) || overlaps(jb, exf, true, true) || overlaps(jb, exd, false, true))
                overlap = true;
            if(!overlap){
                for(Rectangle existing : exf){
                    if(existing.intersects(jb)&&!existing.contains(jb)) {
                        overlap = true;
                        break;
                    }
                }
            }
            if(!overlap){
                if(!overlap){
                    for(Rectangle existing : exd){
                        if (existing.intersects(jb)) {
                            overlap = true;
                            break;
                        }
                    }
                }
            }
            if(!overlap){
                for(Rectangle existing : ex){
                    if(existing.contains(jb)){
                        int leftDiff = Math.abs(jb.x - existing.x); // Distance to left border
    int rightDiff = Math.abs((jb.x + jb.width) - (existing.x + existing.width)); // Distance to right border
    int topDiff = Math.abs(jb.y - existing.y); // Distance to top border
    int bottomDiff = Math.abs((jb.y + jb.height) - (existing.y + existing.height)); // Distance to bottom border

    // Weigh distances based on the lengths of the borders
    int weightedLeftDiff = (jb.height >= jb.width) ? leftDiff : Integer.MAX_VALUE;
    int weightedRightDiff = (jb.height >= jb.width) ? rightDiff : Integer.MAX_VALUE;
    int weightedTopDiff = (jb.width >= jb.height) ? topDiff : Integer.MAX_VALUE;
    int weightedBottomDiff = (jb.width >= jb.height) ? bottomDiff : Integer.MAX_VALUE;

    // Determine the closest weighted border
    int minDiff = Math.min(
        Math.min(weightedLeftDiff, weightedRightDiff),
        Math.min(weightedTopDiff, weightedBottomDiff)
    );

    // Align jb to the nearest border of existing
    if (minDiff == weightedLeftDiff) {
        jb.x = existing.x; // Align to the left border
    } else if (minDiff == weightedRightDiff) {
        jb.x = existing.x + existing.width - jb.width; // Align to the right border
    } else if (minDiff == weightedTopDiff) {
        jb.y = existing.y; // Align to the top border
    } else if (minDiff == weightedBottomDiff) {
        jb.y = existing.y + existing.height - jb.height; // Align to the bottom border
    }


                    }
                }
                for(Rectangle existing : exf){
                    if(existing.contains(jb)){
                        int leftDiff = Math.abs(jb.x - existing.x); // Distance to left border
                            int rightDiff = Math.abs((jb.x + jb.width) - (existing.x + existing.width)); // Distance to right border
                            int topDiff = Math.abs(jb.y - existing.y); // Distance to top border
                            int bottomDiff = Math.abs((jb.y + jb.height) - (existing.y + existing.height)); // Distance to bottom border

                            // Weigh distances based on the lengths of the borders
                            int weightedLeftDiff = (jb.height >= jb.width) ? leftDiff : Integer.MAX_VALUE;
                            int weightedRightDiff = (jb.height >= jb.width) ? rightDiff : Integer.MAX_VALUE;
                            int weightedTopDiff = (jb.width >= jb.height) ? topDiff : Integer.MAX_VALUE;
                            int weightedBottomDiff = (jb.width >= jb.height) ? bottomDiff : Integer.MAX_VALUE;

                            // Determine the closest weighted border
                            int minDiff = Math.min(
                                Math.min(weightedLeftDiff, weightedRightDiff),
                                Math.min(weightedTopDiff, weightedBottomDiff)
                            );

                            // Align jb to the nearest border of existing
                            if (minDiff == weightedLeftDiff) {
                                jb.x = existing.x; // Align to the left border
                            } else if (minDiff == weightedRightDiff) {
                                jb.x = existing.x + existing.width - jb.width; // Align to the right border
                            } else if (minDiff == weightedTopDiff) {
                                jb.y = existing.y; // Align to the top border
                            } else if (minDiff == weightedBottomDiff) {
                                jb.y = existing.y + existing.height - jb.height; // Align to the bottom border
                            }

                    }
                }
                j.setBounds(jb);
            }
                
            }
            }
                if (overlap) {
                    // If overlap occurs, move JLabel to (0, 0)
                    JOptionPane.showMessageDialog(f,"Overlap!!!");
                    j.setLocation(0, 0);
                } else {
                    // Add the new bounds of the JLabel to `ex`
                    if(n==1)
                    ex.add(jb);
                    else
                    if(n==2){
                    exf.add(jb);
                    }
                    else if(n==3){
                        exd.add(jb);
                    }
                }
                if(n==2){
                    c.setComponentZOrder(j, 0);
                }
                else if(n==3){
                    c.setComponentZOrder(j, 0);
                }
                // Repaint the panel to ensure visuals are updated
                c.repaint();
            }
        });
    
        j.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (offset[0] != null) {
                    // Calculate the new location of the JLabel while dragging
                    Point newLocation = SwingUtilities.convertPoint(j, e.getPoint(), c);
                    int newX = newLocation.x - offset[0].x;
                    int newY = newLocation.y - offset[0].y;
    
                    // Keep the JLabel within the bounds of the panel
                    newX = Math.max(0, Math.min(newX, c.getWidth() - j.getWidth()));
                    newY = Math.max(0, Math.min(newY, c.getHeight() - j.getHeight()));
    
                    j.setLocation(newX, newY);
                }
            }
        });
    
        j.setOpaque(true); // Ensure the JLabel is visible
    }
    public void edit(JLabel j){
        int n;
        if(j.getIcon()==null&&j.getHeight()>10&&j.getWidth()>10){
            n=1;
        }
        else if(j.getIcon()!=null){
            n=2;
        }
        else
        {
            n=3;
        }
        JFrame r=new JFrame("Edit");
        JPanel l=new JPanel();
        l.setBounds(50,50,200,400);
        l.setLayout(new BoxLayout(l,BoxLayout.Y_AXIS));
        r.setSize(500,500);
        String[] s={"CHANGE DIMENSION","ROTATE","REMOVE","RENAME"};
        JButton[] b=new JButton[s.length];
        for(int i=0;i<s.length;i++){
            b[i]=new JButton(s[i]);
            b[i].add(Box.createHorizontalGlue());
            b[i].add(Box.createVerticalGlue());
            b[i].setFont(new Font("Times New Roman", Font.ITALIC, 15));
            b[i].setSize(200,50);
            l.add(b[i]);
        }
        r.add(l);
        b[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                r.dispose();
                JFrame r1=new JFrame("Change Dimension");
                r1.setSize(500,500);
                JTextField tf1=new JTextField();
                tf1.setBounds(200,100,100,50);
                JTextField tf2=new JTextField();
                tf2.setBounds(400,300,100,50);
                JLabel j1=new JLabel("Enter the new length");
                j1.setBounds(300,50,150,40);
                JLabel j2=new JLabel("Enter the new width");
                j2.setBounds(300,250,150,40);
                JButton b=new JButton("Enter");
                b.setBounds(200,400,100,50);
                r1.add(tf1);
                r1.add(tf2);
                r1.add(j1);
                r1.add(j2);
                r1.add(b);
                r1.setLayout(null);
                r1.setVisible(true);
                r1.setDefaultCloseOperation(EXIT_ON_CLOSE);
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        int g=Integer.parseInt(tf1.getText());
                        int h=Integer.parseInt(tf2.getText());
                        if(check(g, h)){
                            if(n==1){
                                ex.remove(j.getBounds());
                            }
                            else
                            if(n==2)
                            {
                                exf.remove(j.getBounds());
                            }
                            else
                            if(n==3)
                            {
                                exd.remove(j.getBounds());
                            }
                            j.setBounds(0,0,g,h);
                            if(n==2){
                                ImageIcon or=(ImageIcon)j.getIcon();
                                Image oi=or.getImage();
                                Image resizedImg = oi.getScaledInstance(j.getWidth(), j.getHeight(), Image.SCALE_SMOOTH);
                                ImageIcon ni=new ImageIcon(resizedImg);
                                j.setIcon(ni);

                            }
                            if(n==1){
                                ex.add(j.getBounds());
                            }
                            else
                            if(n==2)
                            {
                                exf.add(j.getBounds());
                            }
                            else
                            if(n==3)
                            {
                                exd.add(j.getBounds());
                            }
                            
                        }
                        r1.dispose();
                    }
                    
                });
                

            }
        });
        b[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                r.dispose();
                JFrame r1=new JFrame("Rotate");
                r1.setSize(500,500);
                JLabel j1=new JLabel("Click on the button to rotate by 90 degrees");
                j1.setBounds(200,200,100,50);
                JButton b=new JButton("Rotate");
                b.setBounds(200,300,100,50);
                r1.add(j1);
                r1.add(b);
                r1.setVisible(true);
                r1.setDefaultCloseOperation(EXIT_ON_CLOSE);
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        if(n==1){
                            ex.remove(j.getBounds());
                        }
                        else
                        if(n==2)
                        {
                            exf.remove(j.getBounds());
                        }
                        else
                        if(n==3){
                            exd.remove(j.getBounds());
                        }
                        j.setBounds(0,0,j.getHeight(),j.getWidth());
                        if(n==2){
                            ImageIcon or=(ImageIcon)j.getIcon();
                            Image oi=or.getImage();
                            Image resizedImg = oi.getScaledInstance(j.getWidth(), j.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon ni=new ImageIcon(resizedImg);
                            j.setIcon(ni);

                        }
                        if(n==1){
                            ex.add(j.getBounds());
                        }
                        else if(n==2)
                        {
                            exf.add(j.getBounds());
                        }
                        else if(n==3)
                        {
                            exd.add(j.getBounds());
                        }

                        r1.dispose();
                    }
                });
            }
        });
        b[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                r.dispose();
                JFrame r1=new JFrame("Remove");
                r1.setSize(500,500);
                JLabel j1=new JLabel("Successfully Removed");
                j1.setBounds(200,200,100,50);
                JButton b=new JButton("Okay");
                b.setBounds(200,300,100,50);
                r1.add(j1);
                r1.add(b);
                r1.setVisible(true);
                r1.setDefaultCloseOperation(EXIT_ON_CLOSE);
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        if(n==1){
                            ex.remove(j.getBounds());
                        }
                        else if(n==2)
                        {
                            exf.remove(j.getBounds());
                        }
                        else if(n==3){
                            exd.remove(j.getBounds());
                        }
                        c.remove(j);
                        c.revalidate();
                        c.repaint();
                        r1.dispose();
                    }
                });

            }
        });
        b[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                r.dispose();
                JFrame r1=new JFrame("Rename");
                r1.setSize(500,500);
                JTextField tf1=new JTextField();
                tf1.setBounds(200,300,100,50);
                JLabel j1=new JLabel("Enter the new name");
                j1.setBounds(200,200,100,50);
                JButton b=new JButton("Enter");
                b.setBounds(200,400,100,50);
                r1.add(tf1);
                r1.add(j1);
                r1.add(b);
                r1.setVisible(true);
                r1.setDefaultCloseOperation(EXIT_ON_CLOSE);
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        j.setText(tf1.getText());
                        r1.dispose();
                    }
                });
                
            }
        });
        r.setVisible(true);
        r.setDefaultCloseOperation(EXIT_ON_CLOSE);
        j.setOpaque(true);
    }
    static class JLabelState implements Serializable {
        int x, y, width, height;
        Color backgroundColor;
        String borderType;
        String text;
        String iconPath;

        public JLabelState(JLabel label) {
            Rectangle bounds = label.getBounds();
            this.x = bounds.x;
            this.y = bounds.y;
            this.width = bounds.width;
            this.height = bounds.height;
            this.backgroundColor = label.getBackground();
            this.text = label.getText();
            Border border = label.getBorder();
            if (border instanceof LineBorder) {
                this.borderType = "LineBorder";
            }
            Icon icon = label.getIcon();
            this.iconPath = (icon instanceof ImageIcon) ? ((ImageIcon) icon).getDescription() : null;
            System.out.println("Saving icon: " + iconPath);

        }
    }

    private void saveLayout() {
        ArrayList<JLabelState> layout = new ArrayList<>();
        for (Component comp : c.getComponents()) {
            if (comp instanceof JLabel) {
                layout.add(new JLabelState((JLabel) comp));
            }
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("layout.ser"))) {
            oos.writeObject(layout);
            JOptionPane.showMessageDialog(f, "Layout saved successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void loadLayout() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("layout.ser"))) {
            ArrayList<JLabelState> layout = (ArrayList<JLabelState>)ois.readObject();
            c.removeAll(); // Clear the panel before loading
            for (JLabelState state : layout) {
                JLabel label = new JLabel(state.text);
                label.setBounds(state.x, state.y, state.width, state.height);
                label.setBackground(state.backgroundColor);
                label.setOpaque(true);
                if ("LineBorder".equals(state.borderType)) {
                    label.setBorder(new LineBorder(Color.BLACK));
                }
                System.out.println("Loading icon: " + state.iconPath);
                URL iconURL = getClass().getResource(state.iconPath);
                    System.out.println("Resolved URL: " + iconURL);
                    if (iconURL == null) {
                        System.out.println("⚠️ Icon path not found in classpath.");
                    } else {
                       ImageIcon originalIcon = new ImageIcon(iconURL);
                        Image scaledImage = originalIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                        label.setIcon(new ImageIcon(scaledImage));
                    }
                c.add(label);
            }
            c.revalidate();
            c.repaint();
            JOptionPane.showMessageDialog(f, "Layout loaded successfully!");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
                  public static void main(String[] args) {
        new Canvas();
       }
}