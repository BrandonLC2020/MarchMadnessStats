import { useState, useEffect } from 'react';
import { SystemHealth } from '../types/api';
import { fetchData } from './apiHelper';

export const useSystemHealth = () => {
  const [data, setData] = useState<SystemHealth | null>(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    let active = true;

    const loadHealth = async () => {
      setLoading(true);
      setError(null);
      try {
        const response = await fetchData<SystemHealth>('/system/health');
        if (active) {
          setData(response);
        }
      } catch (err: any) {
        if (active) {
          setError(err.message || 'Failed to fetch system health');
        }
      } finally {
        if (active) {
          setLoading(false);
        }
      }
    };

    loadHealth();

    return () => {
      active = false;
    };
  }, []);

  return { data, loading, error };
};
