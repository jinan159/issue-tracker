/* eslint-disable jsx-a11y/mouse-events-have-key-events */
/* eslint-disable react/require-default-props */
/* eslint-disable import/no-extraneous-dependencies */
import { useId } from 'react';

import DropBox from '@/components/DropBox';
import Icons from '@/components/DropDown/Icons';
import useMouse from '@/hooks/useMouse';

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
  const [
    isMouseOvered,
    isActive,
    handleMouseOver,
    handleMouseOut,
    handleMouseDown,
    handleMouseUp,
  ] = useMouse(false);

  return (
    <S.Container width={dropDownWidth} height={dropDownHeight}>
      <S.Filter
        onMouseOver={handleMouseOver}
        onMouseOut={handleMouseOut}
        onMouseDown={handleMouseDown}
        onMouseUp={handleMouseUp}
      >
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
          <S.DropDownTitle isMouseOvered={isMouseOvered}>
            {dropDownTitle}
          </S.DropDownTitle>
        </S.DropdownLabel>
        <S.IconContainer>
          <Icons
            type="bottomArrow"
            mode={
              (isActive && 'active') || (isMouseOvered && 'hover') || 'initial'
            }
          />
        </S.IconContainer>
      </S.Filter>
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
