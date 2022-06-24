import { useState } from 'react';

type UseMouseType = [
  boolean,
  boolean,
  () => void,
  () => void,
  () => void,
  () => void
];

export default function useMouse(inintialState = false): UseMouseType {
  const [isMouseOvered, setIsMouseOvered] = useState(inintialState);
  const [isActive, setIsActive] = useState(inintialState);

  const handleMouseOver = () => {
    setIsMouseOvered(true);
  };

  const handleMouseOut = () => {
    setIsMouseOvered(false);
  };

  const handleMouseDown = () => {
    setIsMouseOvered(false);
    setIsActive(true);
  };

  const handleMouseUp = () => {
    setIsMouseOvered(false);
    setIsActive(false);
  };

  return [
    isMouseOvered,
    isActive,
    handleMouseOver,
    handleMouseOut,
    handleMouseDown,
    handleMouseUp,
  ];
}
