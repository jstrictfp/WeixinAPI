package cn.jstrictfp.weixin.util;

import com.vdurmont.emoji.EmojiParser;

public class EmojiUtil {
	
	/**
	 * 将表情设置为HtmlHex格式
	 * @param emoji_str
	 * @return
	 */
	private static String parseToHtmlHexadecimal(String emoji_str){
		return EmojiParser.parseToHtmlHexadecimal(emoji_str);
	}
	
	/**
	 * 将表情设置为HtmlTag格式
	 * @param emoji_str
	 * @return
	 */
	private static String parseToHtmlTag(String emoji_str){
		if(emoji_str != null){
			String str = EmojiParser.parseToHtmlHexadecimal(emoji_str);
			return htmlHexadecimalToHtmlTag(str);
		}
		return null;
	}
	
	/**
	 * 将表情设置为Alias格式
	 * @param emoji_str
	 * @return
	 */
	private static String parseToAliases(String emoji_str){
		return EmojiParser.parseToAliases(emoji_str);
	}
	
	/**
	 * 将表情设置为HtmlDec格式
	 * @param emoji_str
	 * @return
	 */
	private static String parseToHtmlDecimal(String emoji_str){
		return EmojiParser.parseToHtmlDecimal(emoji_str);
	}
	
	/**
	 * 纯文本格式(删除表情)
	 * @param emoji_str
	 * @return
	 */
	private static String removeAllEmojis(String emoji_str){
		return EmojiParser.removeAllEmojis(emoji_str);
	}
	
	/**
	 * 
	 * @param emoji_str emoji_str
	 * @return emoji_result
	 */
	private static String htmlHexadecimalToHtmlTag(String emoji_str){
		if(emoji_str != null){
			return emoji_str.replaceAll("&#x([^;]*);","<span class='emoji emoji$1'></span>");
		}
		return null;
	}
	
	/**
	 * 解析转换表情
	 * @param emoji_str 表情符号
	 * @param type 转换的模式  0  不设置 <br>
						  1 HtmlHex 格式<br>
						  2 HtmlTag 格式<br>
						  3 Alias  格式<br>
						  4 HtmlDec 格式<br>
						  5 PureText 纯文本<br>
	 * @return
	 */
	public static String parse(String emoji_str,int type){
		switch (type) {
		case 1:
			return parseToHtmlHexadecimal(emoji_str);
		case 2:
			return parseToHtmlTag(emoji_str);
		case 3:
			return parseToAliases(emoji_str);
		case 4:
			return parseToHtmlDecimal(emoji_str);
		case 5:
			return removeAllEmojis(emoji_str);
		default:
			return null;
		}
	}
}
