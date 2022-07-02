package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MumblingTest {
	
	@Test
	public void test () {
		System.out.println("Fixed Tests accum");
		assertEquals("A-Bb-Ccc-Dddd", Mumbling.accum("abcd"));
		assertEquals("R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy", Mumbling.accum("RqaEzty"));
		assertEquals("C-Ww-Aaa-Tttt", Mumbling.accum("cwAt"));
		assertEquals("Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu", Mumbling.accum("ZpglnRxqenU"));
        assertEquals("N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb", Mumbling.accum("NyffsGeyylB"));
        assertEquals("M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu", Mumbling.accum("MjtkuBovqrU"));
        assertEquals("E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm", Mumbling.accum("EvidjUnokmM"));
        assertEquals("H-Bb-Iii-Dddd-Eeeee-Vvvvvv-Bbbbbbb-Xxxxxxxx-Nnnnnnnnn-Cccccccccc-Ccccccccccc", Mumbling.accum("HbideVbxncC"));
	}
	

}
