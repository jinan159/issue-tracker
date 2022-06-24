import Icons, { IconType } from '@/components/Icons';

import * as S from './style';

type LabelSizeType = 'large' | 'small';
type LabelStyleType = 'open' | 'close' | 'light' | 'dark' | 'line';

export interface LabelCustomStyleProps {
  color?: string;
  background?: string;
  border?: string;
  fontSize?: string;
  fontWeight?: string;
}

export interface LabelProps extends LabelCustomStyleProps {
  size: LabelSizeType;
  labelStyle: LabelStyleType;
  iconType?: IconType;
  contents?: string;
}

function Label({
  size,
  labelStyle,
  iconType = 'alert',
  contents = 'label',
  ...props
}: LabelProps) {
  const hasIcon = size === 'large';

  const defaultIcons: { [key: string]: IconType } = {
    open: 'alert',
    close: 'archive',
  };

  const defaultContents: { [key: string]: string | undefined } = {
    open: '열린 이슈',
    close: '닫힌 이슈',
    line: '작성자',
  };

  return (
    <S.Label size={size} labelStyle={labelStyle} {...props}>
      {hasIcon && <Icons type={defaultIcons[labelStyle] || iconType} />}
      <S.Contents>{defaultContents[labelStyle] || contents}</S.Contents>
    </S.Label>
  );
}

export default Label;
