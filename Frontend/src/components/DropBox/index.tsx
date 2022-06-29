import * as S from './style';

interface DropBoxProps {
  itemsTitle: string;
  items: string[];
}

export default function DropBox({ itemsTitle, items }: DropBoxProps) {
  return (
    <S.ItemContainer>
      {itemsTitle}
      {items.map((item) => (
        <S.Item key={`issue-filter-${item}`}>{item}</S.Item>
      ))}
    </S.ItemContainer>
  );
}
