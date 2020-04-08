package ru.mail.polis.homework.analyzer;


/**
 * ������� ���������� �������, ���������� ����� ����������� ������ ��������������� � ���� ��� ������
 * ������� ������.
 * ���� ���� ����������� ������, ������� ������� ������� ��������� ���� (�� ��� ��� ���������� ���������, ��� ��� ���
 * ����� ���, ��� ��� �� ����� ���������� ����������, � ����� ������ ��������, ��� ��������� ����������� �������
 * ����� ���-�� ������������� �����). ���� ����������� ������ ��� ����� ��� �������� ������,
 * ��� �� ��� �������� ������� (������� �� ��������) � ���� "������������" �� ��������.
 * <p>
 * ��� �� ���������� ������� ��� ���������� ������, ������� ����� ��� ����� ��� ������� ������
 * �� ���� �������� � ������ TextFilterManager
 * <p>
 * 2 ����� + (2 ����� �� ������ ������ + 1 ���� �� ���� �� ���� ������) ����� 11
 */
public interface TextAnalyzer {

    static final FilterType good = FilterType.GOOD;

    static TextAnalyzer createTooLongAnalyzer(long maxLength) {
        return new TooLongTextFilter(maxLength);
    }

    static TextAnalyzer createSpamAnalyzer(String[] spam) {
        return new SpamTextFilter(spam);
    }

    static TextAnalyzer createNegativeTextAnalyzer() {
        return new NegativeTextFilter();
    }

    /**
     * ��������� ���� ������
     */
    static TextAnalyzer createEmotionalTextFilter() {
        return new EmotionalTextFilter();
    }

    FilterType analyze(String text);
}
