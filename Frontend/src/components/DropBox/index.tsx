/* eslint-disable no-unused-vars */
import * as S from './style';

interface Item {
  title: string;
  keyword: string;
}

interface DropBoxProps {
  itemsTitle: string;
  items: Item[];
  handleClickDropDown: (keyword: string) => void;
}

export default function DropBox({
  itemsTitle,
  items,
  handleClickDropDown,
}: DropBoxProps) {
  return (
    <S.ItemContainer>
      {itemsTitle}
      {items.map(({ title, keyword }) => (
        <S.Item
          key={`issue-filter-${title}`}
          onClick={() => handleClickDropDown(keyword)}
        >
          {title}
        </S.Item>
      ))}
    </S.ItemContainer>
  );
}
