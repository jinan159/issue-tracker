import Icons from '@/components/DropDown/Icons';

import * as S from './style';

interface FilterProps {
  handleMouseOver: () => void;
  handleMouseOut: () => void;
  handleMouseDown: () => void;
  handleMouseUp: () => void;
  dropDownTitle: string;
  dropDownId: string;
  dropDownLabelName: string;
  isMouseOvered: boolean;
  isActive: boolean;
}

export default function Filter({
  handleMouseOver,
  handleMouseOut,
  handleMouseDown,
  handleMouseUp,
  dropDownTitle,
  dropDownId,
  dropDownLabelName,
  isMouseOvered,
  isActive,
}: FilterProps) {
  return (
    <S.Filter
      onMouseOver={handleMouseOver}
      onMouseOut={handleMouseOut}
      onMouseDown={handleMouseDown}
      onMouseUp={handleMouseUp}
    >
      <S.DropDown
        id={dropDownId}
        type="checkbox"
        constentsName={`${dropDownTitle}`}
        labelName={dropDownLabelName}
      />
      <S.DropdownLabel className={dropDownLabelName} htmlFor={dropDownId}>
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
  );
}
