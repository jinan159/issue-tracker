/* eslint-disable jsx-a11y/mouse-events-have-key-events */
/* eslint-disable react/require-default-props */
/* eslint-disable import/no-extraneous-dependencies */
import DropBox from '@/components/DropBox';
import Filter from '@/components/Filter';
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
  const {
    isMouseOvered,
    isActive,
    isClicked,
    handleMouseOver,
    handleMouseOut,
    handleMouseDown,
    handleMouseUp,
    handleClick,
  } = useMouse(false);

  return (
    <S.Container width={dropDownWidth} height={dropDownHeight}>
      <Filter
        handleMouseOver={handleMouseOver}
        handleMouseOut={handleMouseOut}
        handleMouseDown={handleMouseDown}
        handleMouseUp={handleMouseUp}
        dropDownTitle={dropDownTitle}
        isMouseOvered={isMouseOvered}
        isActive={isActive}
        handleClick={handleClick}
      />
      <S.Content
        isClicked={isClicked}
        className={`${dropDownTitle}`}
        width={dropBoxWidth}
        isStartFromRight={isStartFromRight}
      >
        <DropBox itemsTitle={itemsTitle} items={items} />
      </S.Content>
    </S.Container>
  );
}
