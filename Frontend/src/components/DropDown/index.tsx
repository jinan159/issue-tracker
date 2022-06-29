/* eslint-disable react/require-default-props */
/* eslint-disable import/no-extraneous-dependencies */
import { useId } from 'react';

import DropBox from '../DropBox';
import * as S from './style';

interface DropDownProps {
  dropDownWidth: string;
  dropDownHeight: string;
  dropBoxWidth?: string | undefined;
  dropDownTitle: string;
  itemsTitle: string;
  items: string[];
  isStartFromRight?: boolean;
}

export default function DropDown({
  dropDownWidth,
  dropDownHeight,
  dropDownTitle,
  dropBoxWidth = '100%',
  isStartFromRight,
  itemsTitle,
  items,
}: DropDownProps) {
  const id = useId();

  return (
    <S.Container width={dropDownWidth} height={dropDownHeight}>
      <S.DropDown
        id={`dropdown-${dropDownTitle}-${id}`}
        type="checkbox"
        constentsName={`${dropDownTitle}`}
        labelName={`dropdown-label-${dropDownTitle}`}
      />
      <S.DropdownLabel
        className={`dropdown-label-${dropDownTitle}`}
        htmlFor={`dropdown-${dropDownTitle}-${id}`}
      >
        <S.DropDownTitle>{dropDownTitle}</S.DropDownTitle>
      </S.DropdownLabel>
      <S.Content
        className={`${dropDownTitle}`}
        width={dropBoxWidth}
        isStartFromRight={isStartFromRight}
      >
        <DropBox itemsTitle={itemsTitle} items={items} />
      </S.Content>
    </S.Container>
  );
}
