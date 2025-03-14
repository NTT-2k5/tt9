package io.github.sspanak.tt9.ui.main.keys;

import android.content.Context;
import android.util.AttributeSet;

import io.github.sspanak.tt9.languages.LanguageKind;

public class SoftKeyNumber1 extends SoftKeyNumber {
	private static final String DEFAULT_LARGE_LABEL = ",:-)";
	private static final String KOREAN_SMALL_LABEL = "1 :-)";
	private static final String KOREAN_LARGE_LABEL = "ㅣ";

	public SoftKeyNumber1(Context context) { super(context); }
	public SoftKeyNumber1(Context context, AttributeSet attrs) { super(context, attrs); }
	public SoftKeyNumber1(Context context, AttributeSet attrs, int defStyleAttr) { super(context, attrs, defStyleAttr); }

	@Override
	protected String getTitle() {
		if (tt9 == null || tt9.isInputModeNumeric()) {
			return "1";
		}

		return LanguageKind.isKorean(tt9.getLanguage()) ? KOREAN_LARGE_LABEL : DEFAULT_LARGE_LABEL;
	}

	@Override
	protected String getHoldText() {
		if (tt9 == null || tt9.isNumericModeStrict()) {
			return null;
		}

		if (tt9.isInputModeNumeric()) {
			return DEFAULT_LARGE_LABEL;
		}

		if (LanguageKind.isKorean(tt9.getLanguage())) {
			return KOREAN_SMALL_LABEL;
		}

		return super.getLocalizedNumber(getNumber(getId()));
	}
}
