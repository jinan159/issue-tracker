/* eslint-disable react/require-default-props */
/* eslint-disable import/no-extraneous-dependencies */
import { v4 as uuidv4 } from 'uuid';

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

const id = uuidv4();

export default function DropDown({
  dropDownWidth,
  dropDownHeight,
  dropDownTitle,
  dropBoxWidth = '100%',
  isStartFromRight,
  itemsTitle,
  items,
}: DropDownProps) {
  return (
    <S.Container width={dropDownWidth} height={dropDownHeight}>
      <S.DropDown
        id={`dropdown-${dropDownTitle}-${id}`}
        type="checkbox"
        constentsName={`${dropDownTitle}-${id}`}
        labelName={`dropdown-label-${dropDownTitle}-${id}`}
      />
      <S.DropdownLabel
        className={`dropdown-label-${dropDownTitle}-${id}`}
        htmlFor={`dropdown-${dropDownTitle}-${id}`}
      >
        <S.DropDownTitle>{dropDownTitle}</S.DropDownTitle>
      </S.DropdownLabel>
      <S.Content
        className={`${dropDownTitle}-${id}`}
        width={dropBoxWidth}
        isStartFromRight={isStartFromRight}
      >
        <DropBox itemsTitle={itemsTitle} items={items} />
      </S.Content>
    </S.Container>
  );
}
