package org.outstudio.wxtest;

public class StringUtil {

	/**
	 * ���ַ�������Ϊָ�����ȵ��ַ��������Ҳ�����ַ�
	 * 
	 * @param str
	 *            ���ǰ���ַ���
	 * @param ch
	 *            ���ʹ�õ��ַ�
	 * @param len
	 *            �ַ�����Ŀ�곤��
	 * @return ������ַ���
	 */
	public static String paddingRight(String str, char ch, int len) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < len - str.length(); i++) {
			sb.append(ch);
		}
		return sb.toString();
	}

}
