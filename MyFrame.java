package OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyFrame extends JFrame{
	
	Connection connect=null;
    PreparedStatement state=null;
    ResultSet result=null;

    int id=-1;
    int h_id=-1;
    int r_id=-1;

    private JTabbedPane jTab;
    private JPanel client= new JPanel();
    JPanel cUpPanel=new JPanel();
    JPanel cMidPanel=new JPanel();
    JPanel cDownPanel=new JPanel();
    private JPanel hotel= new JPanel();
    JPanel hUpPanel=new JPanel();
    JPanel hMidPanel=new JPanel();
    JPanel hDwnPanel=new JPanel();
    private JPanel reservation= new JPanel();
    JPanel rUpPanel=new JPanel();
    JPanel rMdPanel=new JPanel();
    JPanel rDwnPanel=new JPanel();
    
    JPanel spravkaPo2=new JPanel();
    JPanel spUpPanel=new JPanel();
    JPanel spMidPanel=new JPanel();
    JPanel spDwnPanel=new JPanel();
    
    //spravka 2--------------------------------------
    JPanel spravkaPo22=new JPanel();
    JPanel s2UpPanel=new JPanel();
    JPanel s2MidPanel=new JPanel();
    JPanel s2DwnPanel=new JPanel();
    


    JTable table=new JTable();
    JScrollPane myScroll=new JScrollPane(table);

    JTable hTable=new JTable();
    JScrollPane hMyScroll=new JScrollPane(hTable);
    
    JTable rTable=new JTable();
    JScrollPane rMyScroll=new JScrollPane(rTable);
    
    JTable sprTable=new JTable();
    JScrollPane sprMyscroll=new JScrollPane(sprTable);
    
    JTable spr2Table=new JTable();
    JScrollPane spr2Myscroll=new JScrollPane(spr2Table);
    
    
       
    JComboBox<String> clienCB=new JComboBox<String>();   
    JComboBox<String>hotelCb=new JComboBox<String>();
    
    JComboBox<String> sprCCB=new JComboBox<String>();
    JComboBox<String> sprHCB=new JComboBox<String>();
    
    JComboBox<String>spr2EgnCB=new JComboBox<String>();
    JComboBox<String>spr2ResNumCB=new JComboBox<String>();
    

    JLabel fNameL = new JLabel("Име");
    JLabel lNameL = new JLabel("Фамилия");
    JLabel telephoneL=new JLabel("Телефон");
    JLabel egnL=new JLabel("ЕГН");


    JTextField fNameTF = new JTextField(20);
    JTextField lNameTF = new JTextField(20);
    JTextField egnTF=new JTextField(20);
    JTextField telephoneTF=new JTextField(20);

    JButton addBt=new JButton("Добави");
    JButton delBt=new JButton("Изтрий");
    JButton ChgBt=new JButton("Промени");
    JButton searchEgnBt=new JButton("Търси по ЕГН");
    JButton refreshBt=new JButton("Обнови");

    //ХОТЕЛИИИИ

    JLabel hNameL=new JLabel("Име на хотел");
    JLabel hPrice=new JLabel("Цена за нощувка");

    JTextField hNameTF=new JTextField(50);
    JTextField hPriceTF=new JTextField(20);

    JButton hAddBt=new JButton("Добави");
    JButton hDelBt=new JButton("Изтрий");
    JButton hChgBt=new JButton("Промени");
    JButton hSearchEgnBt=new JButton("Търси по цена");
    JButton hRefreshBt=new JButton("Обнови");
    
    
    //reservatioooons
    
     
    JLabel cNameL=new JLabel("Име на клиент");
    JLabel hrNameL=new JLabel("Име на хотел");
    JLabel rNumber=new JLabel("Номер на резервация");
    
    JTextField resNum=new JTextField(20);
    
    JButton rAddBt=new JButton("Добави");
    JButton rDelBt=new JButton("Изтрий");
    JButton rChgBt=new JButton("Промени");

    //spravka--------------------------------
    JLabel sprNameL=new JLabel("Име на клиент");
    JLabel sprHNameL=new JLabel("Име на хотел");
    
    JButton sprSearch=new JButton("Провери");
    
    JLabel s2EgnL=new JLabel("ЕГН на клиент");
    JLabel s2RNumL=new JLabel("Номер на резервация");
    
    JButton s2Search=new JButton("Провери");
    
    




    public MyFrame(){
        jTab=new JTabbedPane();
        jTab.setSize(650,550);
        jTab.addTab("Clients",client);
        jTab.addTab("Hotels",hotel);
        jTab.addTab("Reservations",reservation);
        jTab.addTab("Справка по име и хотел",spravkaPo2);
        jTab.addTab("Справка по ЕГН и Рез.номер", spravkaPo22);
        

        client.setLayout(new GridLayout(3,1));
        client.add(cUpPanel);
        client.add(cMidPanel);
        client.add(cDownPanel);

        cUpPanel.setLayout(new GridLayout(5,2));
        cUpPanel.add(fNameL);
        cUpPanel.add(fNameTF);
        cUpPanel.add(lNameL);
        cUpPanel.add(lNameTF);
        cUpPanel.add(egnL);
        cUpPanel.add(egnTF);
        cUpPanel.add(telephoneL);
        cUpPanel.add(telephoneTF);

        cMidPanel.setLayout(new GridLayout(2,5));
        cMidPanel.add(addBt);
        addBt.addActionListener(new AddActionC());
        cMidPanel.add(delBt);
        delBt.addActionListener(new DeleteAction());
        cMidPanel.add(ChgBt);
        ChgBt.addActionListener(new EditAction());
        cMidPanel.add(searchEgnBt);
        searchEgnBt.addActionListener(new SearchAction());
        cMidPanel.add(refreshBt);
        refreshBt.addActionListener(new RefreshAction());

        myScroll.setPreferredSize(new Dimension(450,150));
        cDownPanel.add(myScroll);
        table.addMouseListener(new TableView());
        
        //HOTEEEELS--------------------------------------------------------------------
        
        
        hotel.setLayout(new GridLayout(3,1));
        hotel.add(hUpPanel);
        hotel.add(hMidPanel);
        hotel.add(hDwnPanel);

        hUpPanel.setLayout(new GridLayout(3,2));
        hUpPanel.add(hNameL);
        hUpPanel.add(hNameTF);
        hUpPanel.add(hPrice);
        hUpPanel.add(hPriceTF);

        hMidPanel.setLayout(new GridLayout(2,5));
        hMidPanel.add(hAddBt);
        hAddBt.addActionListener(new HaddAction());
        hMidPanel.add(hDelBt);
        hDelBt.addActionListener(new HdeleteAction());
        hMidPanel.add(hChgBt);
        hChgBt.addActionListener(new HeditAction());
        hMidPanel.add(hSearchEgnBt);
        hSearchEgnBt.addActionListener(new HsearchAction());
        hMidPanel.add(hRefreshBt);
        hRefreshBt.addActionListener(new HrefreshAction());

        hMyScroll.setPreferredSize(new Dimension(350,150));
        hDwnPanel.add(hMyScroll);
        hTable.addMouseListener(new HtableView());
        
        //RESERVATIONNNNNN--------------------------------------------------------------------

        reservation.setLayout(new GridLayout(3,1));
        reservation.add(rUpPanel);
        reservation.add(rMdPanel);
        reservation.add(rDwnPanel);
        
        rUpPanel.setLayout(new GridLayout(3,2));
        rUpPanel.add(cNameL);
        rUpPanel.add(clienCB);
        rUpPanel.add(hrNameL);
        rUpPanel.add(hotelCb);
        rUpPanel.add(rNumber);
        rUpPanel.add(resNum);
        
        rMdPanel.setLayout(new GridLayout(2,3));
        rMdPanel.add(rAddBt);
        rAddBt.addActionListener(new RaddAction());
        rMdPanel.add(rChgBt);
        rChgBt.addActionListener(new ReditAction());
        rMdPanel.add(rDelBt);
        rDelBt.addActionListener(new RdeleteAction());
        
        rMyScroll.setPreferredSize(new Dimension(450,150));
        rDwnPanel.add(rMyScroll);
        rTable.addMouseListener(new RtableViwe());
        
        //Spravka po2 1---------------------------------------------------------------------------
        spravkaPo2.setLayout(new GridLayout(3,1));
        spravkaPo2.add(spUpPanel);
        spravkaPo2.add(spMidPanel);
        spravkaPo2.add(spDwnPanel);
        
        spUpPanel.setLayout(new GridLayout(2,2));
        spUpPanel.add(sprNameL);
        spUpPanel.add(sprCCB);
        spUpPanel.add(sprHNameL);
        spUpPanel.add(sprHCB);
        
        spMidPanel.setLayout(new GridLayout(3,1));
        spMidPanel.add(sprSearch);
        sprSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect=DBConnection.getConnection();
				String sql="Select res_num,fname ,lname,hotel_name from reservation R join Client C on r.client_id=c.client_id join hotel H on r.hotel_id=h.hotel_id where fname+' '+lname=? and hotel_name=?";
				try {
					state=connect.prepareStatement(sql);
					state.setString(1, sprCCB.getSelectedItem().toString().substring(2).replace(".", ""));
					state.setString(2, sprHCB.getSelectedItem().toString().substring(2).replace(".", ""));
					ResultSet resulttt=state.executeQuery();
					sprTable.setModel(new MyModel(resulttt));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        
        sprMyscroll.setPreferredSize(new Dimension(500,100));
        spDwnPanel.add(sprMyscroll);
        
        //spravka po 2 2-----------------------------------------------------------------------
        
        spravkaPo22.setLayout(new GridLayout(3,1));
        spravkaPo22.add(s2UpPanel);
        spravkaPo22.add(s2MidPanel);
        spravkaPo22.add(s2DwnPanel);
        
        s2UpPanel.setLayout(new GridLayout(2,2));
        s2UpPanel.add(s2EgnL);
        s2UpPanel.add(spr2EgnCB);
        s2UpPanel.add(s2RNumL);
        s2UpPanel.add(spr2ResNumCB);
        
        s2MidPanel.setLayout(new GridLayout(2,1));
        s2MidPanel.add(s2Search);
        s2Search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect=DBConnection.getConnection();
				String sql="Select egn,fname ,lname,hotel_name from reservation R join Client C on r.client_id=c.client_id join hotel H on r.hotel_id=h.hotel_id where egn=? and res_num=?";
				try {
					state=connect.prepareStatement(sql);
					state.setString(1, spr2EgnCB.getSelectedItem().toString().substring(2).replaceAll("\\D+", ""));
					state.setString(2, spr2ResNumCB.getSelectedItem().toString().substring(2).replaceAll("\\D+", ""));
					ResultSet resultt=state.executeQuery();
					spr2Table.setModel(new MyModel(resultt));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
        
        spr2Myscroll.setPreferredSize(new Dimension(500,100));
        s2DwnPanel.add(spr2Myscroll);
        
        
        
        
        


       
        getContentPane().add(jTab,BorderLayout.CENTER);
        
        
        
       

        this.setSize(550,550);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        refreshTable();
        hRefreshTable();
        rRefreshTable();
        refreshComboClient();
        refreshComboHotel();
        refreshSprCC();
        redreshSprCH();
        refreshComboEGN();
        refreshComboRN();

    }
    
    
    
    public void refreshTable() {
    	connect=DBConnection.getConnection();
    	try {
			state=connect.prepareStatement("select*from client");
			result=state.executeQuery();
			table.setModel(new MyModel(result));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void clearForm() {
    	fNameTF.setText("");
    	lNameTF.setText("");
    	egnTF.setText("");
    	telephoneTF.setText("");
    }


    class AddActionC implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            connect=DBConnection.getConnection();
            String sql="insert into client values(?,?,?,?)";
            try {
                state=connect.prepareStatement(sql);
                state.setDouble(1,Double.parseDouble(egnTF.getText()));
                state.setString(2,fNameTF.getText());
                state.setString(3,lNameTF.getText());                
                state.setDouble(4,Double.parseDouble(telephoneTF.getText()));

                state.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            
            refreshTable();
            clearForm();
            refreshComboClient();
        }
    }
    
    
    class TableView implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row=table.getSelectedRow();
			id=Integer.parseInt(table.getValueAt(row, 0).toString());
			
			if(e.getClickCount()>1) {
				egnTF.setText(table.getValueAt(row, 1).toString());
				fNameTF.setText(table.getValueAt(row, 2).toString());
				lNameTF.setText(table.getValueAt(row, 3).toString());
				telephoneTF.setText(table.getValueAt(row, 4).toString());
			}
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    }
    
    class DeleteAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			connect=DBConnection.getConnection();
			String sql="delete from client where client_id=?";
			try {
				state=connect.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				
				refreshTable();
				clearForm();
				id=-1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated method stub
			
		}
    	
    }
    
    class SearchAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			connect=DBConnection.getConnection();
			String sql="select*from client where egn=?";
			try {
				state=connect.prepareStatement(sql);
							
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				try {
					state.setDouble(1, Double.parseDouble(egnTF.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			try {
				result=state.executeQuery();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				table.setModel(new MyModel(result));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
    	
    }
    
    class RefreshAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshTable();
			clearForm();
			
		}
    	
    }
    
    class EditAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			connect=DBConnection.getConnection();
			String sql="update CLIENT set EGN=?,FName=?,LName=?,telephone=? where client_id=?";
			try {
				state=connect.prepareStatement(sql);
				state.setDouble(1,Double.parseDouble(egnTF.getText()));
                state.setString(2,fNameTF.getText());
                state.setString(3,lNameTF.getText());                
                state.setDouble(4,Double.parseDouble(telephoneTF.getText()));
                state.setInt(5, id);
                
                state.execute();
                refreshTable();
				clearForm();
                id=-1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
    	
    }
    

    public void hRefreshTable() {
    	connect=DBConnection.getConnection();
    	try {
			state=connect.prepareStatement("select*from hotel");
			result=state.executeQuery();
			hTable.setModel(new MyModel(result));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void hClearForm() {

    	hNameTF.setText("");
    	hPriceTF.setText("");
    }
    
    
    class HaddAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			connect=DBConnection.getConnection();
			String sql="insert into hotel values(?,?)";
			
			try {
				state=connect.prepareStatement(sql);
				state.setString(1, hNameTF.getText());
				state.setInt(2, Integer.parseInt(hPriceTF.getText()));
				
				state.execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			hRefreshTable();
			hClearForm();
			refreshComboHotel();
			
			
		}
    	
    }
    
    class HtableView implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row=hTable.getSelectedRow();
			h_id=Integer.parseInt(hTable.getValueAt(row, 0).toString());
			
			if(e.getClickCount()>1) {
				hNameTF.setText(hTable.getValueAt(row, 1).toString());
				hPriceTF.setText(hTable.getValueAt(row, 2).toString());
				
			}
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    	
    }

    class HdeleteAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			connect=DBConnection.getConnection();
			String sql="delete from hotel where hotel_id=?";
			try {
				state=connect.prepareStatement(sql);
				state.setInt(1, h_id);
				state.execute();
				
				hRefreshTable();
				hClearForm();
				h_id=-1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
    	
    	
    }
    
    class HsearchAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			connect=DBConnection.getConnection();
			String sql="select*from hotel where hotel_price=?";
			try {
				state=connect.prepareStatement(sql);
							
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				try {
					state.setInt(1, Integer.parseInt(hPriceTF.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			try {
				result=state.executeQuery();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				hTable.setModel(new MyModel(result));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
    	
    	
    }
    
    class HrefreshAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			hRefreshTable();
			hClearForm();
			
		}
    	
    	
    }
    
    class HeditAction implements ActionListener{
    	
		@Override
		public void actionPerformed(ActionEvent e) {
			connect=DBConnection.getConnection();
			String sql="update HOTEL set HOTEL_NAME=?,HOTEL_PRICE=? where HOTEL_ID=?";
			try {
				state=connect.prepareStatement(sql);
				state.setString(1, hNameTF.getText());
				state.setDouble(2, Double.parseDouble(hPriceTF.getText()));
				state.setInt(3, h_id);
				
				state.execute();
				hRefreshTable();
				hClearForm();
				h_id=-1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
    	
    }

    
    
    public void refreshComboClient() {
    	clearComboClient();
    	String sql="select client_id,fname,lname from client";
    	connect=DBConnection.getConnection();
    	String item="";
    	try {
			state=connect.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next()) {
				item=result.getObject(1).toString()+"."+result.getObject(2).toString()+" "+result.getObject(3).toString();
				clienCB.addItem(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    public void refreshComboHotel() {
    	clearComboHotels();
    	String sql="select hotel_id,hotel_name from hotel";
    	connect=DBConnection.getConnection();
    	String item="";
    	try {
			state=connect.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next()) {
				item=result.getObject(1).toString()+"."+result.getObject(2).toString();
				hotelCb.addItem(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void rRefreshTable() {
    	connect=DBConnection.getConnection();
    	try {
			state=connect.prepareStatement("select reservation_id,res_num,fname,lname,hotel_name from reservation r join client c on r.client_id=c.client_id join hotel h on r.hotel_id=h.hotel_id");
			result=state.executeQuery();
			rTable.setModel(new MyModel(result));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
    
    public void clearComboClient() {
    	clienCB.removeAllItems();
    }
    
    public void clearComboHotels() {
    	hotelCb.removeAllItems();
    }
    
    
    class RaddAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			connect=DBConnection.getConnection();
			String sql="insert into reservation values(?,?,?)";
			try {
				state=connect.prepareStatement(sql);
				state.setInt(1, Integer.parseInt(resNum.getText()));
				state.setInt(2, Integer.parseInt(clienCB.getSelectedItem().toString().replaceAll("\\D+", "")));
				state.setInt(3, Integer.parseInt(hotelCb.getSelectedItem().toString().replaceAll("\\D+", "")));
				
				state.execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			rRefreshTable();
		}
    	
    	
    }
    
    class RtableViwe implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row=rTable.getSelectedRow();
			r_id=Integer.parseInt(rTable.getValueAt(row, 0).toString());
			
			if(e.getClickCount()>1) {
				resNum.setText(rTable.getValueAt(row, 1).toString());
				clienCB.getModel().setSelectedItem(rTable.getValueAt(row, 2));
				hotelCb.getModel().setSelectedItem(rTable.getValueAt(row, 4));
				
				
				
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    }
    
    class RdeleteAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			connect=DBConnection.getConnection();
			String sql="delete from reservation where reservation_id=?";
			try {
				state=connect.prepareStatement(sql);
				state.setInt(1, r_id);
				state.execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
    	
    }
    
    class ReditAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			connect=DBConnection.getConnection();
			String sql="update RESERVATION set RES_NUM=?,CLIENT_ID=?,Hotel_ID=? where reservation_id=?";
			try {
				state=connect.prepareStatement(sql);
				state.setString(1, resNum.getText());
				state.setInt(2, Integer.parseInt(clienCB.getSelectedItem().toString().replaceAll("\\D+", "")));
				state.setInt(3, Integer.parseInt(hotelCb.getSelectedItem().toString().replaceAll("\\D+", "")));
				state.setInt(4, r_id);
				state.execute();
				r_id=-1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
    	
    }
    
    public void refreshSprCC() {
    	String sql="select client_id,fname,lname from client";
    	connect=DBConnection.getConnection();
    	String item="";
    	try {
			state=connect.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next()) {
				item=result.getObject(1).toString()+"."+result.getObject(2).toString()+" "+result.getObject(3).toString();
				sprCCB.addItem(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   
    public void redreshSprCH() {
    	String sql="select hotel_id,hotel_name from hotel";
    	connect=DBConnection.getConnection();
    	String item="";
    	try {
			state=connect.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next()) {
				item=result.getObject(1).toString()+"."+result.getObject(2).toString();
				sprHCB.addItem(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void refreshComboEGN() {
    	
    	String sql="select client_id,egn from client";
    	connect=DBConnection.getConnection();
    	String item="";
    	try {
			state=connect.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next()) {
				item=result.getObject(1).toString()+"."+result.getObject(2).toString();
				spr2EgnCB.addItem(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public void refreshComboRN() {
    	
    	String sql="select reservation_id,res_num from reservation";
    	connect=DBConnection.getConnection();
    	String item="";
    	try {
			state=connect.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next()) {
				item=result.getObject(1).toString()+"."+result.getObject(2).toString();
				spr2ResNumCB.addItem(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
