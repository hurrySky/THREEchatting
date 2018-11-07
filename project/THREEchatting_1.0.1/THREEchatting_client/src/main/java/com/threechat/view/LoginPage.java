package com.threechat.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.threechat.view.common.ButtonUtil;
import com.threechat.view.common.ImagePanal;

/**
 * 登录界面
 * @author lixin
 */
public class LoginPage extends JFrame implements MouseMotionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	/**
	 *  初始水平位置
	 */
	private int init_x;
	/**
	 *  初始垂直位置
	 */
	private int int_y;
	/**
	 * 界面宽
	 */
	private int width;
	/**
	 * 界面高
	 */
	private int height;
	/**
	 * 定义指针对象，获得指针位置
	 */
	private static Point p = new Point();
	
	// 定义界面组件
	/**
	 *  上半部面板
	 */
	private ImagePanal topPanel;
	/**
	 *  上半部面板背景图片
	 */
	private Image topImage;
	/**
	 * 退出按钮
	 */
	private JButton exitButton;
	/**
	 * 小化按钮
	 */
	private JButton minButton;
	/**
	 *  下半部面板
	 */
	private JPanel underPanel;
	private JTextField loginNameText, passwordText; // 定义账号框 ， 密码框
	private JButton loginInButton; // 定义登录按钮
	
	public static void main(String[] args) {
		LoginPage loginPage = new LoginPage();
	}
	
	/**
	 * 无参构造方法
	 */
	public LoginPage() {
		init();
		inittopPanel();
		initUnderPanel();
		
		Container container = new Container();
		container.setLayout(null);
		topPanel.setBounds(0,0,this.width,this.height / 2);
		container.add(topPanel);
		underPanel.setBounds(0, this.height / 2, width, height / 2);
		container.add(underPanel);
		this.add(container);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		this.setLocation(init_x, int_y);
		this.setSize(width, height);
		//设置JFrame禁用本地外观，使用下面自定义设置的外观；
        //this.setDefaultLookAndFeelDecorated(true);
		this.setUndecorated(true);
		// 定义圆角形状
		final Shape shape = new RoundRectangle2D.Double(0d, 0d, this.getWidth(), this.getHeight(), 4, 4);
		this.setShape(shape);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	/**
	 * 初始化读取配置
	 */
	private void init(){
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
		this.init_x = Integer.parseInt(properties.getProperty("login_init_x"));
		this.int_y = Integer.parseInt(properties.getProperty("login_int_y"));
		this.width = Integer.parseInt(properties.getProperty("login_width"));
		this.height = Integer.parseInt(properties.getProperty("login_height"));
	}
	/**
	 * 初始化 上半部 面板
	 */
	private void inittopPanel(){
		// 获得退出按钮
		exitButton = ButtonUtil.getExitButton(Color.black, Color.white);
		exitButton.addMouseListener(this);
		// 获得最小化按钮
		minButton = ButtonUtil.getMinButton(Color.black, Color.white);
		minButton.addMouseListener(this);
		
		topImage = Toolkit.getDefaultToolkit().getImage("resource/images/top.gif");
		topPanel = new ImagePanal(topImage, width, height);
		topPanel.setLayout(null);
		
		minButton.setBounds(this.width - 40,0,20,20);
		topPanel.add(minButton);
		exitButton.setBounds(this.width - 20,0,20,20);
		topPanel.add(exitButton);
	}
	/**
	 *  初始化 下半部 面板
	 */
	private void initUnderPanel() {
		loginNameText = new JTextField(25);
		passwordText = new JTextField(25);
		loginNameText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK)); // 设置使只有下边框
		loginNameText.setBackground(new Color(248, 248, 255));
		loginNameText.setBounds(120, 10, 210,30);
		passwordText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));  // 设置使只有下边框
		passwordText.setBackground(new Color(248, 248, 255));
		passwordText.setBounds(120, 45, 210,30);
		
		loginInButton = new JButton("登             录");
		loginInButton.setBounds(120, 85, 210,30);
		loginInButton.setBackground(new Color(135, 206, 250));
		loginInButton.setBorder(null);
		loginInButton.setFocusPainted(false); // 不绘制文字周围的边框
		
		underPanel = new JPanel();
		underPanel.setBackground(new Color(248, 248, 255));
		underPanel.setLayout(null);
		underPanel.add(loginNameText);
		underPanel.add(passwordText);
		underPanel.add(loginInButton);
		underPanel.setLocation(0, 0);
		underPanel.setSize(width, height / 2);
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
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == exitButton) {
			exitButton.setBackground(Color.red);
			exitButton.setForeground(Color.black); // 设置文字颜色为白色
		}
		if (e.getSource() == minButton) {
			minButton.setForeground(new Color(135, 206, 250)); // 设置文字颜色为白色
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == exitButton) {
			exitButton.setBackground(Color.black);
			exitButton.setForeground(Color.white); // 设置文字颜色为白色
		}
		if (e.getSource() == minButton) {
			minButton.setForeground(Color.white); // 设置文字颜色为白色
		}
	}
}
