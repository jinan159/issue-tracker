/* eslint-disable no-unused-vars */
import axios, { AxiosResponse } from 'axios';

import * as S from './style';

interface Item {
  filter: string;
  description: string;
}

interface DropBoxProps {
  itemsTitle: string;
  items: Item[];
}

export default function DropBox({ itemsTitle, items }: DropBoxProps) {
  const handleClickDropDown = (keyword: string) => {
    getFilterdIssues(keyword);
  };

  const getFilterdIssues = async (keyword: string) => {
    const id = 1;
    const response: AxiosResponse = await axios.get(
      `${process.env.SERVER_ENDPOINT}/api/issuegroup/${id}/issues`,
      {
        params: { q: keyword },
      }
    );
  };

  return (
    <S.ItemContainer>
      {itemsTitle}
      {items.map(({ description, filter }) => (
        <S.Item
          key={`issue-filter-${description}`}
          onClick={() => handleClickDropDown(filter)}
        >
          {description}
        </S.Item>
      ))}
    </S.ItemContainer>
  );
}
