package com.threechat.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import com.threechat.base.ContactsItemData;
import com.threechat.base.MyCellRenderer;
import com.threechat.view.common.ButtonUtil;
import com.threechat.view.common.ImageButton;
import com.threechat.view.common.MyScrollBarUI;

public class ChattingPage extends JFrame implements MouseMotionListener, MouseListener{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 定义指针对象，获得指针位置
	 */
	private static Point p = new Point();
	/**
	 *  初始水平位置
	 */
	private int chatting_init_x; 
	/**
	 *  初始垂直位置
	 */
	private	int chatting_init_y;
	/**
	 * 界面宽
	 */
	private	int chatting_width;
	/**
	 * 界面高
	 */
	private	int chatting_height;
	/**
	 * 左菜单面板
	 */
	private JPanel leftMenuPanel;
	/**
	 * 头像
	 */
	private ImageButton headButton;
	/**
	 *  聊天按钮
	 */
	private ImageButton chatButton;
	
	/**
	 *  联系人按钮
	 */
	private ImageButton contactsButton;
	
	/**
	 * 上部面板，装载最小化，关闭，标题等组件
	 */
	private JPanel topPanel;
	/**
	 * 退出按钮
	 */
	private JButton exitButton;
	/**
	 * 小化按钮
	 */
	private JButton minButton;
	/**
	 * 上部面板，左边区域
	 */
	private JPanel topPanel_leftPanel;
	/**
	 * 上部面板，右边区域
	 */
	//private JPanel topPanel_rightPanel;
	
	/**
	 * 联系人or历史对话人面板
	 */
	private JPanel contactsPanel;
	/**
	 * 联系人or历史对话人面板 滚动条
	 */
	private JScrollPane contactsJscrollPanel;
	/**
	 * 联系人or历史对话人列表组件
	 */
	private JList<ContactsItemData> contactsList;
	/**
	 * 聊天窗口面板
	 */
	private JPanel chatingPanel;
	
	public static void main(String[] args) {
		ChattingPage chattingPage = new ChattingPage();
	}
	
	/**
	 * 构造方法
	 */
	public ChattingPage() {
		init(); // 获得配置文件信息
		initLeftMenuPanel(); // 初始化 左边菜单
		initTopPanel(); // 初始化顶部面板
		initContactsJscrollPanel(); //  联系人or历史对话人面板 滚动条
		initContactsPanel(); // 初始化联系人or历史对话人面板
		initChatingPanel(); // 初始化聊天窗口面板
		
		Container container = new Container();
		container.setLayout(null);
		container.add(leftMenuPanel);
		container.add(topPanel);
		container.add(contactsPanel);
		container.add(chatingPanel);
	//	container.add(contactsJscrollPanel);
		
		this.add(container);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		this.setLocation(chatting_init_x, chatting_init_y);
		this.setSize(chatting_width, chatting_height);
		this.setUndecorated(true);
		// 定义圆角形状
		final Shape shape = new RoundRectangle2D.Double(0d, 0d, this.getWidth(), this.getHeight(), 4, 4);
		this.setShape(shape);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * 加载读取配置信息
	 */
	private void init() {
		Properties properties = new Properties();
		// 使用InPutStream流读取properties文件
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("resource/config/viewPage.properties"));
		} catch (FileNotFoundException e1) {
			System.out.println("配置文件未找到!");
			e1.printStackTrace();
		}
		try {
			properties.load(bufferedReader);
		} catch (IOException e) {
			System.out.println("配置文件加载失败!");
			e.printStackTrace();
		}
		// 获取key对应的value值
		this.chatting_init_x = Integer.parseInt(properties.getProperty("chatting_init_x"));
		this.chatting_init_y = Integer.parseInt(properties.getProperty("chatting_init_y"));
		this.chatting_width = Integer.parseInt(properties.getProperty("chatting_width"));
		this.chatting_height = Integer.parseInt(properties.getProperty("chatting_height"));
	}
	
	/**
	 * 初始化左菜单面板界面
	 */
	private void initLeftMenuPanel() {
		headButton = new ImageButton("", 50, 50);
		headButton.setBounds(5, 10, 50, 50);
		headButton.setBackground(new Color(40, 41, 43));
		
		chatButton = new ImageButton("resource/images/chat_active.jpg", 50, 50);
		chatButton.setBounds(5, 100, 50, 50);
		chatButton.setBackground(new Color(40, 41, 43));
		chatButton.addMouseListener(this);
		chatButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 鼠标进入button指针变手指
		
		contactsButton = new ImageButton("resource/images/contacts.jpg", 50, 50);
		contactsButton.setBounds(5, 165, 50, 50);
		contactsButton.setBackground(new Color(40, 41, 43));
		contactsButton.addMouseListener(this);
		contactsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 鼠标进入button指针变手指
		
		leftMenuPanel = new JPanel();
		leftMenuPanel.setBackground(new Color(40, 41, 43));
		leftMenuPanel.setLayout(null);
		leftMenuPanel.setBounds(0,0,60,chatting_height);
		leftMenuPanel.add(headButton);
		leftMenuPanel.add(chatButton);
		leftMenuPanel.add(contactsButton);
	}
	
	/**
	 * 初始化 顶部
	 */
	private void initTopPanel() {
		initTopPanel_leftPanel(); // 上部面板，左边区域
		// 获得退出按钮
		exitButton = ButtonUtil.getExitButton(new Color(245, 245, 245), Color.BLACK);
		exitButton.setBounds(chatting_width - 80, 0, 20, 20);
		exitButton.addMouseListener(this);
		// 获得最小化按钮
		minButton = ButtonUtil.getMinButton(new Color(245, 245, 245), Color.BLACK);
		minButton.setBounds(chatting_width - 100, 0, 20, 20);
		minButton.addMouseListener(this);
		
		topPanel = new JPanel();
	//	topPanel.setBackground(new Color(245, 245, 245));
	//	topPanel.setBackground(new Color(198, 47, 47));
		topPanel.setLayout(null);
		topPanel.setBounds(60,0,chatting_width - 60, 60);
		topPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(219, 217, 216)));
	
		topPanel.add(exitButton);
		topPanel.add(minButton);
		topPanel.add(topPanel_leftPanel);
	}
	/**
	 * 初始化顶部面板 左边区域
	 */
	private void initTopPanel_leftPanel() {
		
		topPanel_leftPanel = new JPanel();
		topPanel_leftPanel.setLayout(null);
		topPanel_leftPanel.setBackground(new Color(237, 234, 232));
		topPanel_leftPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, new Color(219, 217, 216)));
		topPanel_leftPanel.setBounds(0, 0, 250, 60);
	}
	
	/**
	 * 初始化联系人or历史对话人面板
	 */
	private void initContactsPanel() {
		
		contactsPanel = new JPanel();
		contactsPanel.setLayout(null);
		contactsPanel.setBackground(new Color(237, 234, 232));
		contactsPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(219, 217, 216)));
		contactsPanel.setBounds(60, 60, 250, chatting_height - 60);
		contactsPanel.add(contactsJscrollPanel);
	}
	
	/**
	 * 初始化聊天窗口面板
	 */
	private void initChatingPanel() {
		chatingPanel = new JPanel();
		chatingPanel.setLayout(null);
		
		chatingPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, new Color(219, 217, 216)));
		chatingPanel.setBounds(310, 60, chatting_width - 310, chatting_height - 60);
	}
	/**
	 * 初始化联系人or历史对话人面板 滚动条
	 */
	private void initContactsJscrollPanel(){
		Icon icon1 = new ImageIcon("resource/images/default_head.jpg");
		Icon icon2 = new ImageIcon("resource/images/default_head.jpg");
		Icon icon3 = new ImageIcon("resource/images/default_head.jpg");
		Icon icon4 = new ImageIcon("resource/images/default_head.jpg");
		Icon icon5 = new ImageIcon("resource/images/default_head.jpg");
		Icon[] icons = { icon1, icon2, icon3, icon4, icon5};
		
		Vector<ContactsItemData> items = new Vector<ContactsItemData>();
		ContactsItemData contactsItemData = new ContactsItemData("李新", icon1);
		ContactsItemData contactsItemData2 = new ContactsItemData("azhegn", icon2);
		ContactsItemData contactsItemData3 = new ContactsItemData("lixin", icon3);
		ContactsItemData contactsItemData4 = new ContactsItemData("lixin", icon4);
		ContactsItemData contactsItemData5 = new ContactsItemData("lixin", icon5);
		items.add(contactsItemData);
		items.add(contactsItemData2);
		items.add(contactsItemData3);
		items.add(contactsItemData4);
		items.add(contactsItemData5);
		
		contactsList = new JList<ContactsItemData>();
		contactsList.setBounds(0, 0, 250, chatting_height-60);
		contactsList.setSelectionBackground(new Color(237, 234, 232));
		contactsList.setSelectionForeground(Color.WHITE);
		contactsList.setForeground(Color.DARK_GRAY);
		contactsList.setListData(items);
		contactsList.setCellRenderer(new MyCellRenderer());
		contactsList.setBackground(new Color(192,192,192));
		contactsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 设置单一选择模式（每次只能  有一个元素被选中）
		
		contactsJscrollPanel = new JScrollPane(contactsList);
		contactsJscrollPanel.setBorder(null);
		contactsJscrollPanel.setBounds(0, 0, 250, chatting_height - 60);
		
		contactsJscrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		contactsJscrollPanel.getVerticalScrollBar().setSize(10, 10);
		contactsJscrollPanel.getVerticalScrollBar().setUI(new MyScrollBarUI());
		

	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Point p1 = this.getLocation();
		this.setLocation(p1.x+e.getX()-p.x,p1.y+e.getY()-p.y);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == chatButton) {
			ImageIcon icon = new ImageIcon("resource/images/chat_active.jpg");
			chatButton.setIcon(icon);
			ImageIcon icon2 = new ImageIcon("resource/images/contacts.jpg");
			contactsButton.setIcon(icon2);
		}
		if (e.getSource() == contactsButton) {
			ImageIcon icon = new ImageIcon("resource/images/chat.jpg");
			chatButton.setIcon(icon);
			ImageIcon icon2 = new ImageIcon("resource/images/contacts_active.jpg");
			contactsButton.setIcon(icon2);
		}
		if (e.getSource() == exitButton) {
			this.dispose();
			System.exit(0);
		}
		if (e.getSource() == minButton) {
			this.setExtendedState(JFrame.ICONIFIED);//最小化窗体
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		p.x= e.getX();
		p.y = e.getY();
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == exitButton) {
			exitButton.setBackground(Color.red);
			exitButton.setForeground(Color.white); // 设置文字颜色为白色
		}
		if (e.getSource() == minButton) {
			minButton.setForeground(new Color(135, 206, 250)); // 设置文字颜色为该色
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == exitButton) {
			exitButton.setBackground(new Color(245, 245, 245));
			exitButton.setForeground(Color.black); // 设置文字颜色为白色
		}
		if (e.getSource() == minButton) {
			minButton.setForeground(Color.black); // 设置文字颜色为白色
		}
	}
}
