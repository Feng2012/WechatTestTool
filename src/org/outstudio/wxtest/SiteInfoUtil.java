package org.outstudio.wxtest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class SiteInfoUtil {

	private static final String configFilePath = "config.txt";

	/**
	 * �������ļ��ж�ȡ������������Ϣ
	 */
	public static List<SiteInfo> getSiteInfo() {
		File file = new File(configFilePath);
		List<SiteInfo> siteInfos = new ArrayList<>();
		try {
			List<String> lines = FileUtils.readLines(file);
			if (lines.isEmpty()) {
				return siteInfos;
			}
			for (String line : lines) {
				String[] info = line.split(" ", 2);
				SiteInfo siteInfo = new SiteInfo();
				siteInfo.setUrl(info[0]);
				siteInfo.setToken(info[1]);
				siteInfos.add(siteInfo);
			}
			return siteInfos;
		} catch (IOException e) {
			return siteInfos;
		}
	}

	/**
	 * ��������������Ϣ��������ļ���
	 */
	public static void saveSiteInfo(List<SiteInfo> siteInfos) {
		if (siteInfos == null || siteInfos.isEmpty()) {
			return;
		}
		List<String> lines = new ArrayList<>();
		for (SiteInfo siteInfo : siteInfos) {
			lines.add(siteInfo.getUrl() + " " + siteInfo.getToken());
		}
		File file = new File(configFilePath);
		try {
			FileUtils.writeLines(file, lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
