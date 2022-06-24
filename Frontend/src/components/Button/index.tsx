import React from 'react';

import Icons, { IconType } from '@/components/Icons';

import * as S from './style';

export type ButtonStyleType =
  | 'large'
  | 'smallStandard'
  | 'mediumStandard'
  | 'smallSecondary'
  | 'mediumText'
  | 'smallText';

export interface ButtonCustomStyleProps {
  width?: string;
  height?: string;
  color?: string;
  background?: string;
  border?: string;
  borderRadius?: string;
  fontSize?: string;
  fontWeight?: string;
}

export interface ButtonProps extends ButtonCustomStyleProps {
  buttonStyle: ButtonStyleType;
  iconType?: IconType;
  contents?: string;
  children?: React.ReactNode;
  disabled?: boolean;
  onClick?: React.MouseEventHandler<HTMLButtonElement>;
}

export interface StyledButtonProps extends ButtonCustomStyleProps {
  buttonStyle: ButtonStyleType;
}

function Button({
  buttonStyle = 'large',
  contents,
  children,
  iconType = 'plus',
  ...props
}: ButtonProps) {
  const hasIcon =
    buttonStyle === 'smallStandard' ||
    buttonStyle === 'smallSecondary' ||
    buttonStyle === 'mediumText' ||
    buttonStyle === 'smallText';

  return (
    <S.Button buttonStyle={buttonStyle} {...props}>
      {hasIcon && <Icons type={iconType} />}
      <S.Contents>{contents || children}</S.Contents>
    </S.Button>
  );
}

export default Button;
