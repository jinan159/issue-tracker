/* eslint-disable no-unused-vars */
import DropDown from '@/components/DropDown';

import * as S from './style';

interface Item {
  title: string;
  keyword: string;
}

interface FilterSeatchBarProps {
  dropDownWidth: string;
  dropDownHeight: string;
  dropBoxWidth?: string | undefined;
  dropDownTitle: string;
  itemsTitle: string;
  items: Item[];
  handleClickDropDown: (keyword: string) => void;
}

export default function FilterSeatchBar({
  dropDownWidth,
  dropDownHeight,
  dropDownTitle,
  dropBoxWidth,
  itemsTitle,
  items,
  handleClickDropDown,
}: FilterSeatchBarProps) {
  return (
    <S.FilterSearchBarContainer>
      <DropDown
        dropDownWidth={dropDownWidth}
        dropDownHeight={dropDownHeight}
        dropBoxWidth={dropBoxWidth}
        dropDownTitle={dropDownTitle}
        itemsTitle={itemsTitle}
        items={items}
        handleClickDropDown={handleClickDropDown}
      />
      <S.SearchBar
        type="text"
        placeholder="is:issue is:open"
        height={dropDownHeight}
      />
    </S.FilterSearchBarContainer>
  );
}
