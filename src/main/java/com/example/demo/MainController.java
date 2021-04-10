package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
	
@RequestMapping(value="/")	
public ModelAndView indexPost(ModelAndView mv) {
	ArrayList<String[]>customers=new ArrayList<String[]>();
	customers.add(new String[] {"佐藤HTML太郎","35歳","男性"});
	customers.add(new String[] {"鈴木Java五郎","24歳","男性"});
	customers.add(new String[] {"高橋CSS子","29歳","女性"});
	customers.add(new String[] {"岡田python明子","20歳","女性"});
	mv.addObject("customers",customers);
	mv.setViewName("index");
	return mv;
}

@RequestMapping("/{num}")
public ModelAndView index(@PathVariable int num,ModelAndView mv) {
String hantei = "";
System.out.println(num);

//素数判定
if(num <= 0 || num == 1)
{
	hantei = "は素数じゃないです…";
}
else
{
	for(int i = 2; i < num; i++) 
	{
		if(num % i == 0)
		{
			hantei = "は素数じゃないです…";
			break;
		}
		else if(num % i == 1)
		{
			hantei = "は素数です！";
			break;
		}
	}
}
System.out.println(num + hantei);
mv.addObject("num", num);
mv.addObject("hantei", hantei);
mv.setViewName("prime");
return mv;
}

@RequestMapping(value="/fact", method=RequestMethod.GET)
public ModelAndView indexGet(ModelAndView mv) {
mv.addObject("ans", "階乗の計算をします");
mv.setViewName("fact");
return mv;
}

@RequestMapping(value="/fact", method=RequestMethod.POST)
public ModelAndView indexPost(ModelAndView mv,
@RequestParam("factVal")Integer fact) {
	int ans = 0;
	for(int i = 0; i <= fact; i++)
	{
		ans += i;
	}
mv.addObject("ans", ans);
mv.setViewName("fact");
return mv;
}

}

